package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};
        Random random = new Random();

        System.out.printf("%-10s | %-12s | %-12s | %-12s | %-12s%n", "Size", "Structure", "Insert (ms)", "Search (ms)", "Delete (ms)");
        System.out.println("-----------------------------------------------------------------------");

        for (int n : sizes) {
            List<Integer> data = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                data.add(random.nextInt(n * 10));
            }

            List<Integer> searchKeys = new ArrayList<>(data);
            Collections.shuffle(searchKeys);

            // --- BST BENCHMARK ---
            BST bst = new BST();
            long start = System.nanoTime();
            for (int key : data) bst.insert(key);
            double bstInsert = (System.nanoTime() - start) / 1e6;

            start = System.nanoTime();
            for (int key : searchKeys) bst.search(key);
            double bstSearch = (System.nanoTime() - start) / 1e6;

            start = System.nanoTime();
            for (int key : searchKeys) bst.delete(key);
            double bstDelete = (System.nanoTime() - start) / 1e6;

            System.out.printf("%-10d | %-12s | %-12.4f | %-12.4f | %-12.4f%n", n, "BST", bstInsert, bstSearch, bstDelete);

            // --- HASH TABLE BENCHMARK ---
            HashTable ht = new HashTable(n * 2);
            start = System.nanoTime();
            for (int key : data) ht.insert(key);
            double htInsert = (System.nanoTime() - start) / 1e6;

            start = System.nanoTime();
            for (int key : searchKeys) ht.search(key);
            double htSearch = (System.nanoTime() - start) / 1e6;

            start = System.nanoTime();
            for (int key : searchKeys) ht.delete(key);
            double htDelete = (System.nanoTime() - start) / 1e6;

            System.out.printf("%-10d | %-12s | %-12.4f | %-12.4f | %-12.4f%n", n, "HashTable", htInsert, htSearch, htDelete);
            System.out.println("-----------------------------------------------------------------------");
        }
    }
}