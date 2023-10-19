package custom;

import java.time.LocalDate;

public class Product {
    private String name;
    private double price;
    private LocalDate expirationDate;
    private int stockQuantity;
    private Boolean isOnSale;

    // IN CONSTRUCTOR USE SETTER METHOFS
    public Product(String name, double price, LocalDate expirationDate, int stockQuantity, Boolean isOnSale) {
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
        this.stockQuantity = stockQuantity;
        this.isOnSale = isOnSale;
    }
    // expirationDate attribute is always later than the current date
    public boolean isValid() {
        LocalDate currentDate = LocalDate.now();
        return expirationDate.isAfter(currentDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name can not be null and empty");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Product price cannot be negative");
        }
        this.price = price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate == null) {
            throw new IllegalArgumentException("Product expiration date cannot be null");
        }
        if (expirationDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Product expiration date cannot be in the past");
        }
        this.expirationDate = expirationDate;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("Product stock quantity cannot be negative");
        }
        this.stockQuantity = stockQuantity;
    }

    public boolean isOnSale() {
        return isOnSale;
    }

    public void setOnSale(Boolean onSale) {
        if(onSale == null){
            throw new IllegalArgumentException("On sale can not be null.");
        }
        isOnSale = onSale;
    }

    // If the product is on sale, its price must be less than its original price.
    public boolean isPriceValid() {
        double originalPrice = getOriginalPrice();
        return price <= originalPrice || !isOnSale;
    }

    // If the product is out of stock, its stock quantity must be 0.
    public boolean isStockQuantityValid() {
        return stockQuantity >= 0 || isOutOfStock();
    }

    // If the product is on sale, it cannot be out of stock.
    public boolean isOnSaleValid() {
        return !isOutOfStock() || !isOnSale;
    }

    private double getOriginalPrice() {
        return isOnSale ? price * 2 : price;
    }

    private boolean isOutOfStock() {
        return stockQuantity == 0;
    }
}
