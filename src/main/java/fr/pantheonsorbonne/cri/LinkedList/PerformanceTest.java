package fr.pantheonsorbonne.cri.LinkedList;

public class PerformanceTest {

    public static void main(String[] args) {
        StringLinkedList myList = new StringLinkedList();
        int[] levels = {100, 500, 750, 1000, 1250, 1500, 1750, 2000, 3000, 4000, 5000, 10000, 20000, 50000}; // Different levels to test

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

            // For searching, use the last element added, ensuring we're testing the worst-case scenario
            // This is the last element's "name" or value
            String searchFor = "Element " + (level - 1); // Adjusted to always search for the last element

            long startContainsTime = System.nanoTime();
            boolean contains = myList.Contains(searchFor);
            long endContainsTime = System.nanoTime();
            long durationContains = (endContainsTime - startContainsTime) / 1000; // Convert to microseconds
            System.out.println("Time taken to search the last element (" + searchFor + "): " + durationContains + " µs, Found: " + contains);
        }
    }
}
