package com.csc483.assignment;

public class Product {
    private int productId;
    private String productName;
    private String category;
    private double price;
    private int stockQuantity;

    public Product(int productId, String productName, String category, double price, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }

    public void setProductName(String productName) { this.productName = productName; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(double price) { this.price = price; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    @Override
    public String toString() {
        return "Product{ID=" + productId + ", Name='" + productName + "', Category='" + category +
               "', Price=$" + String.format("%.2f", price) + ", Stock=" + stockQuantity + '}';
    }
}
