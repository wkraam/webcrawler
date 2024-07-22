/**
 * value -1.0d is null
 */

package org.example.objects;

import java.time.LocalDateTime;

public class ApteegiInfoRida {
    String pharmacyName;
    LocalDateTime lastUpdate;
    String productName;
    Double fixedPrice;
    Double price;
    Double discountCardPrice;
    Double discount50;
    Double discount75;
    Double discount90;
    Double discount100;

    public ApteegiInfoRida(String pharmacyName, LocalDateTime lastUpdate, String productName, Double fixedPrice) {
        this.pharmacyName = pharmacyName;
        this.lastUpdate = lastUpdate;
        this.productName = productName;
        this.fixedPrice = fixedPrice;
    }

    public ApteegiInfoRida(String pharmacyName, LocalDateTime lastUpdate, String productName, Double fixedPrice,
                           Double price, Double discountCardPrice, Double discount50, Double discount75, Double discount90,
                           Double discount100) {
        this.pharmacyName = pharmacyName;
        this.lastUpdate = lastUpdate;
        this.productName = productName;
        this.fixedPrice = fixedPrice;
        this.price = price;
        this.discountCardPrice = discountCardPrice;
        this.discount50 = discount50;
        this.discount75 = discount75;
        this.discount90 = discount90;
        this.discount100 = discount100;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getFixedPrice() {
        return fixedPrice;
    }

    public void setFixedPrice(Double fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountCardPrice() {
        return discountCardPrice;
    }

    public void setDiscountCardPrice(Double discountCardPrice) {
        this.discountCardPrice = discountCardPrice;
    }

    public Double getDiscount50() {
        return discount50;
    }

    public void setDiscount50(Double discount50) {
        this.discount50 = discount50;
    }

    public Double getDiscount75() {
        return discount75;
    }

    public void setDiscount75(Double discount75) {
        this.discount75 = discount75;
    }

    public Double getDiscount90() {
        return discount90;
    }

    public void setDiscount90(Double discount90) {
        this.discount90 = discount90;
    }

    public Double getDiscount100() {
        return discount100;
    }

    public void setDiscount100(Double discount100) {
        this.discount100 = discount100;
    }
}
