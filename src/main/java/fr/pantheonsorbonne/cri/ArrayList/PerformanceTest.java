package fr.pantheonsorbonne.cri.ArrayList;

public class PerformanceTest {

    public static void main(String[] args) {
        ArrayList myList;
        // Expanded and more granular range of levels to test
        int[] levels = {10, 1000000};

        for (int level : levels) {
            // Reset the list for each level
            myList = new ArrayList(); // Ensure the list is reset for each level

            // Timing add operations
            long startAddTime = System.nanoTime();
            for (int i = 0; i < level; i++) {
                myList.add("Element " + i);
            }
            long endAddTime = System.nanoTime();
            long durationAdd = (endAddTime - startAddTime) / 1000; // Convert to microseconds
            System.out.println("Time taken to add " + level + " elements: " + durationAdd + " µs");

            // For searching, always use the last element's index for the worst-case scenario
            // This is the index and value of the last element added
            String searchFor = "Element " + (level - 1);

            // Timing contains operations
            long startContainsTime = System.nanoTime();
            boolean contains = myList.contains(searchFor);
            long endContainsTime = System.nanoTime();
            long durationContains = (endContainsTime - startContainsTime) / 1000; // Convert to microseconds
            System.out.println("Time taken to search the last element (" + searchFor + "): " + durationContains + " µs, Found: " + contains);
        }
    }
}
