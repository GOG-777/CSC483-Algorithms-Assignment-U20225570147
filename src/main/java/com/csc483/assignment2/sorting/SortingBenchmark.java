package com.csc483.assignment2.sorting;

import java.util.*;

public class SortingBenchmark {

    public static void main(String[] args) {
        System.out.println("Running sorting benchmarks (this may take a couple of minutes for n=100,000)...");
        int[] sizes = {100, 1000, 10000, 100000};
        String[] dataTypes = {"Random", "Sorted", "Reverse", "Nearly Sorted", "Many Duplicates"};

        for (String type : dataTypes) {
            System.out.println("\n=================================================================");
            System.out.println("SORTING ALGORITHMS COMPARISON - " + type.toUpperCase() + " DATA");
            System.out.println("=================================================================");
            System.out.printf("%-12s %-10s %-12s %-15s %-10s%n", "Input Size", "Algorithm", "Time (ms)", "Comparisons", "Swaps");
            for (int size : sizes) {
                int[] data = generateData(size, type);
                runTest("Insertion", data.clone(), size, type);
                runTest("Merge", data.clone(), size, type);
                runTest("Quick", data.clone(), size, type);
            }
        }
    }

    private static void runTest(String algoName, int[] arr, int size, String type) {
        long totalTime = 0;
        long totalComp = 0;
        long totalSwaps = 0;
        for (int run = 0; run < 5; run++) {
            int[] copy = arr.clone();
            long start = System.nanoTime();
            SortResult result = sort(copy, algoName);
            totalTime += (System.nanoTime() - start);
            totalComp += result.comparisons;
            totalSwaps += result.swaps;
        }
        double avgTime = totalTime / 5.0 / 1_000_000;
        long avgComp = totalComp / 5;
        long avgSwaps = totalSwaps / 5;

        System.out.printf("%-12d %-10s %-12.2f %-15d %-10d%n", size, algoName, avgTime, avgComp, avgSwaps);
    }

    private static SortResult sort(int[] arr, String algo) {
        SortResult result = new SortResult();
        if (algo.equals("Insertion")) insertionSort(arr, result);
        else if (algo.equals("Merge")) mergeSort(arr, result);
        else if (algo.equals("Quick")) quickSort(arr, 0, arr.length - 1, result);
        return result;
    }

    // Insertion Sort with counters
    private static void insertionSort(int[] arr, SortResult r) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                r.comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    r.swaps++;
                    j--;
                } else break;
            }
            arr[j + 1] = key;
            r.swaps++;
        }
    }

    // Merge Sort with counters
    private static void mergeSort(int[] arr, SortResult r) {
        if (arr.length <= 1) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left, r);
        mergeSort(right, r);
        merge(arr, left, right, r);
    }

    private static void merge(int[] arr, int[] left, int[] right, SortResult r) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            r.comparisons++;
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                r.swaps++;
            }
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // Quick Sort with counters
    private static void quickSort(int[] arr, int low, int high, SortResult r) {
        if (low < high) {
            int pi = partition(arr, low, high, r);
            quickSort(arr, low, pi - 1, r);
            quickSort(arr, pi + 1, high, r);
        }
    }

    private static int partition(int[] arr, int low, int high, SortResult r) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            r.comparisons++;
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j, r);
            }
        }
        swap(arr, i + 1, high, r);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j, SortResult r) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        r.swaps++;
    }

    private static int[] generateData(int n, String type) {
        Random rand = new Random(42);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt(n * 10);

        if (type.equals("Sorted")) Arrays.sort(arr);
        else if (type.equals("Reverse")) {
            Arrays.sort(arr);
            for (int i = 0; i < n / 2; i++) {
                int temp = arr[i]; arr[i] = arr[n - 1 - i]; arr[n - 1 - i] = temp;
            }
        }
        else if (type.equals("Nearly Sorted")) {
            Arrays.sort(arr);
            for (int i = 0; i < n / 10; i++) {
                int idx1 = rand.nextInt(n);
                int idx2 = rand.nextInt(n);
                int temp = arr[idx1]; arr[idx1] = arr[idx2]; arr[idx2] = temp;
            }
        }
        else if (type.equals("Many Duplicates")) {
            for (int i = 0; i < n; i++) arr[i] = rand.nextInt(10);
        }
        return arr;
    }

    static class SortResult {
        long comparisons = 0;
        long swaps = 0;
    }
}
