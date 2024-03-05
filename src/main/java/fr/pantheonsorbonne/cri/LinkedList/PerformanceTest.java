package fr.pantheonsorbonne.cri.LinkedList;

import java.util.Random;

public class PerformanceTest {

    public static void main(String[] args) {
        StringLinkedList myList = new StringLinkedList();
        Random rand = new Random();
        int[] levels = {100,500, 750, 1000, 1250, 1500, 1750, 2000, 3000, 4000, 5000}; // Different levels to test

        for (int level : levels) {
            // Reset the list for each level
            myList.clear();
            
            // Add elements
            long startAddTime = System.nanoTime();
            for (int i = 0; i < level; i++) {
                myList.add("Element " + i);
            }
            long endAddTime = System.nanoTime();
            long durationAdd = (endAddTime - startAddTime) / 1000; // Convert to microseconds
            System.out.println("Time taken to add " + level + " elements: " + durationAdd + " µs");

            // Check contains
            // Using a random element that is guaranteed to be in the list for a meaningful measurement
            String searchFor = "Element " + rand.nextInt(level);
            long startContainsTime = System.nanoTime();
            boolean contains = myList.Contains(searchFor);
            long endContainsTime = System.nanoTime();
            long durationContains = (endContainsTime - startContainsTime) / 1000; // Convert to microseconds
            System.out.println("Time taken to search an element (" + searchFor + "): " + durationContains + " µs, Found: " + contains);
        }
    }
}
