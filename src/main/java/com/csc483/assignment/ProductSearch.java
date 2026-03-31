package com.csc483.assignment;

public class ProductSearch {

    public static Product sequentialSearchById(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return products[i];
            }
        }
        return null;
    }

    public static Product binarySearchById(Product[] products, int targetId) {
        int low = 0;
        int high = products.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midId = products[mid].getProductId();
            if (midId == targetId) {
                return products[mid];
            } else if (midId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static Product searchByName(Product[] products, String targetName) {
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null;
    }
}
