package org.example.webcrawlers;

import org.example.Main;
import org.example.objects.ApteegiInfoRida;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ApteegiInfo {

    public void apteegiInfo(int waitTime) {
        int connectionIndex = 1;
        String[] testConnections = {"https://www.neti.ee", "http://www.apteegiinfo.ee/search/prices?query=L-THYROXIN%20BERLIN-CHEMIE%20TBL%2050MCG%20N100"};
        WebDriver driver = new ChromeDriver();

        driver.get(testConnections[connectionIndex]);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
        System.out.println(driver.getTitle());
        System.out.println("------------------------------------------------------");

        List<WebElement> hinnaInfoTabel = driver.findElements(By.cssSelector(".panel.panel-default.panel-price.ng-scope"));


        for (WebElement element : hinnaInfoTabel) {
            //take each row of selected prescription and find the last updated time
            //find the last time the price was updated
            WebElement updateTimeElement = element.findElement(By.cssSelector(".panel-heading.clearfix")).findElement(By.tagName("span"));
            LocalDateTime updateTime = parseUpdateTime(updateTimeElement.getAttribute("textContent")); //TODO: does not find the datetime - also make it return datetime obj

            //name of the pharmacy
            WebElement pharmacyNameElement = element.findElement(By.cssSelector(".panel-heading.clearfix")).findElement(By.tagName("h4"));
            String pharmacyName = pharmacyNameElement.getAttribute("innerText");
            System.out.println(pharmacyName + ":");

            //get each row of prescription of different pricing
            List<WebElement> priceTableRows = element.findElement(By.cssSelector(".table.table-striped.table-price")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));


            for (WebElement row : priceTableRows) { //each row has multiple prices for the same prescription - for whatever reason.
                //Getting the name
                WebElement nameElement = row.findElement(By.cssSelector(".text-bold"));
                String name = nameElement.getAttribute("textContent").strip();

                //Getting the fixed price
                WebElement fixedPriceElement = row.findElement(By.cssSelector(".nowrap.text-right.price-cell"));
                double fixedPrice = Double.parseDouble(fixedPriceElement.getAttribute("innerText").strip().replaceAll("€", "")) ;

                //Getting the discounted prices, if they are even there
                Double[] discount = new Double[6];
                WebElement discountRow;

                int colspan;
                try {
                    discountRow = row.findElement(By.cssSelector(".text-center.ng-scope"));
                    colspan = Integer.parseInt(discountRow.getAttribute("colspan"));

                } catch (Exception e) {
                    colspan = 0;
                }
                if (colspan == 6) {

                    discount[0] = null;
                    discount[1] = null;
                    discount[2] = null;
                    discount[3] = null;
                    discount[4] = null;
                    discount[5] = null;

                    System.out.printf("\t\t%s\t\t%s\t\t%s\n", priceTableRows.size(), name, fixedPrice);
                    ApteegiInfoRida rowObject = new ApteegiInfoRida(pharmacyName, updateTime, name, fixedPrice);
                    Main.apteegiInfoRidaArrayList.add(rowObject);


                } else {
                    List<WebElement> discountItems = row.findElements(By.cssSelector(".nowrap.text-right.price-cell.text-bold.ng-scope"));

                    int i = 0;
                    for (WebElement discountElement : discountItems) {
                        String discountPrice = discountElement.getAttribute("innerText").strip();
                        if (discountPrice.isEmpty()){
                            discount[i++] = -1d;
                        } else {
                            discount[i++] = Double.parseDouble(discountPrice.replaceAll("€",""));
                        }
                    }

                    System.out.printf("\t\t%s\t\t%s\t\t%s\t\t%s,%s,%s,%s,%s,%s\n", priceTableRows.size(), name, fixedPrice, discount[0], discount[1], discount[2], discount[3], discount[4], discount[5]);
                    ApteegiInfoRida rowObject = new ApteegiInfoRida(pharmacyName, updateTime, name, fixedPrice, discount[0], discount[1], discount[2], discount[3], discount[4], discount[5]);
                    Main.apteegiInfoRidaArrayList.add(rowObject);
                }
            }
        }
        driver.quit();
    }

    private LocalDateTime parseUpdateTime(String input) {
        if (input.equals("Hetkel suletud")){

            return LocalDateTime.now();
        } else {

            //the input does not have year included, so it is needed to add.
            //DateTimeFormatter.ofPattern("dd.MM HH:mm:ss")
            String[] inputs = input.split(" ");
            String date = inputs[0];
            String time = inputs[1];
            date += LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy"));

            return LocalDateTime.parse(date+time);
        }
    }
}
