package com.csc483.assignment;

import java.util.*;

public class HybridProductCatalog {
    private final List<Product> sortedProducts; // always kept sorted by ID
    private final Map<String, Product> nameIndex;

    public HybridProductCatalog(Product[] initialProducts) {
        sortedProducts = new ArrayList<>(Arrays.asList(initialProducts));
        sortedProducts.sort(Comparator.comparingInt(Product::getProductId));
        nameIndex = new HashMap<>();
        for (Product p : sortedProducts) {
            nameIndex.put(p.getProductName().toLowerCase(), p);
        }
    }

    public Product binarySearchById(int targetId) {
        int low = 0;
        int high = sortedProducts.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midId = sortedProducts.get(mid).getProductId();
            if (midId == targetId) return sortedProducts.get(mid);
            else if (midId < targetId) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public Product searchByNameHybrid(String targetName) {
        return nameIndex.get(targetName.toLowerCase());
    }

    public void addProduct(Product newProduct) {
        int low = 0;
        int high = sortedProducts.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (sortedProducts.get(mid).getProductId() < newProduct.getProductId()) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        sortedProducts.add(low, newProduct);
        nameIndex.put(newProduct.getProductName().toLowerCase(), newProduct);
    }

    public List<Product> getSortedProducts() {
        return new ArrayList<>(sortedProducts);
    }
}
