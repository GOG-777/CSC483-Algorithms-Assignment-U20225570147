package com.csc483.assignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductSearchTest {

    @Test
    void testSequentialSearchById() {
        Product[] testProducts = new Product[3];
        testProducts[0] = new Product(101, "Test1", "Phone", 499.99, 10);
        testProducts[1] = new Product(102, "Test2", "Laptop", 899.99, 5);
        testProducts[2] = new Product(103, "Test3", "Headphones", 129.99, 20);

        assertNotNull(ProductSearch.sequentialSearchById(testProducts, 102));
        assertNull(ProductSearch.sequentialSearchById(testProducts, 999));
    }

    @Test
    void testBinarySearchById() {
        Product[] sorted = new Product[3];
        sorted[0] = new Product(101, "Test1", "Phone", 499.99, 10);
        sorted[1] = new Product(102, "Test2", "Laptop", 899.99, 5);
        sorted[2] = new Product(103, "Test3", "Headphones", 129.99, 20);

        assertNotNull(ProductSearch.binarySearchById(sorted, 102));
        assertNull(ProductSearch.binarySearchById(sorted, 999));
    }

    @Test
    void testEdgeCases() {
        assertNull(ProductSearch.sequentialSearchById(new Product[0], 1));
        assertNull(ProductSearch.binarySearchById(new Product[0], 1));
    }
}
