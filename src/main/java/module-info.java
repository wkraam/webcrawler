module webcrawler.with.jsoup {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.seleniumhq.selenium.api;
    requires org.seleniumhq.selenium.chrome_driver;


    opens org.example to javafx.fxml;
    exports org.example;
}