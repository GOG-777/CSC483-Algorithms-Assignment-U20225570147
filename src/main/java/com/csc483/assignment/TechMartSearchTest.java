package com.csc483.assignment;

import java.util.*;

public class TechMartSearchTest {
    public static void main(String[] args) {
        System.out.println("Generating 100,000 products...");
        Product[] products = generateProducts(100000);

        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts, Comparator.comparingInt(Product::getProductId));

        HybridProductCatalog catalog = new HybridProductCatalog(products);

        System.out.println("\n=================================================================");
        System.out.println("TECHMART SEARCH PERFORMANCE ANALYSIS (n = 100,000 products)");
        System.out.println("=================================================================\n");

        System.out.println("SEQUENTIAL SEARCH:");
        measureSequentialId(products, "Best Case (ID found at position 0)", products[0].getProductId());
        measureSequentialId(products, "Average Case (random ID)", getRandomProductId(products));
        measureSequentialId(products, "Worst Case (ID not found)", 999999);

        System.out.println("\nBINARY SEARCH:");
        measureBinaryId(sortedProducts, "Best Case (ID at middle)", sortedProducts[sortedProducts.length / 2].getProductId());
        measureBinaryId(sortedProducts, "Average Case (random ID)", getRandomProductId(products));
        measureBinaryId(sortedProducts, "Worst Case (ID not found)", 999999);

        System.out.println("\nHYBRID NAME SEARCH:");
        measureNameSearchHybrid(catalog, "Average search time");
        measureInsertTime(catalog, "Average insert time");

        System.out.println("=================================================================");
    }

    // (the rest of the helper methods are the same as I gave you before - measureSequentialId, measureBinaryId, etc.)
    // I kept it short here to avoid scrolling hell. If you want the full block again just say "send full main file" and I'll paste it.

    private static void measureSequentialId(Product[] products, String label, int targetId) {
        long start = System.nanoTime();
        ProductSearch.sequentialSearchById(products, targetId);
        long time = (System.nanoTime() - start) / 1_000_000;
        System.out.printf("%s: %.3f ms%n", label, (double) time);
    }

    private static void measureBinaryId(Product[] products, String label, int targetId) {
        long start = System.nanoTime();
        ProductSearch.binarySearchById(products, targetId);
        long time = (System.nanoTime() - start) / 1_000_000;
        System.out.printf("%s: %.3f ms%n", label, (double) time);
    }

    private static void measureNameSearchHybrid(HybridProductCatalog catalog, String label) {
        long start = System.nanoTime();
        catalog.searchByNameHybrid("Samsung Smartphone 5423");
        long time = (System.nanoTime() - start) / 1_000_000;
        System.out.printf("%s: %.3f ms%n", label, (double) time);
    }

    private static void measureInsertTime(HybridProductCatalog catalog, String label) {
        long total = 0;
        for (int i = 0; i < 5; i++) {
            Product newP = new Product(200001 + i, "Test Insert " + i, "Accessory", 99.99, 10);
            long start = System.nanoTime();
            catalog.addProduct(newP);
            total += (System.nanoTime() - start);
        }
        double avg = (total / 5.0) / 1_000_000;
        System.out.printf("%s: %.3f ms%n", label, avg);
    }

    private static Product[] generateProducts(int n) {
        Random rand = new Random(42);
        String[] categories = {"Smartphone", "Laptop", "Headphones", "Tablet", "Smartwatch", "Camera", "Drone", "Router", "Speaker", "Charger"};
        String[] brands = {"Samsung", "Apple", "Sony", "Dell", "HP", "Bose", "DJI", "Netgear", "JBL", "Anker"};
        Product[] prods = new Product[n];
        Set<Integer> usedIds = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int id;
            do {
                id = rand.nextInt(200000) + 1;
            } while (usedIds.contains(id));
            usedIds.add(id);

            String name = brands[rand.nextInt(brands.length)] + " " + categories[rand.nextInt(categories.length)] + " " + (1000 + rand.nextInt(9000));
            String cat = categories[rand.nextInt(categories.length)];
            double price = 50.0 + rand.nextDouble() * 2000.0;
            int stock = rand.nextInt(500) + 10;
            prods[i] = new Product(id, name, cat, price, stock);
        }
        return prods;
    }

    private static int getRandomProductId(Product[] products) {
        return products[new Random().nextInt(products.length)].getProductId();
    }
}
