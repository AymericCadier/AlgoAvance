package fr.pantheonsorbonne.cri.ArrayList;

public class PerformanceTest {

    public static void main(String[] args) {
        ArrayList myList;
        // Expanded and more granular range of levels to test
        int[] levels = {100, 500, 1000, 5000, 10000, 20000, 50000, 100000};

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

            // Generate a random index for the contains test, ensuring it's within the added range
            int searchIndex = (int) (Math.random() * level);
            String searchFor = "Element " + searchIndex;

            // Timing contains operations
            long startContainsTime = System.nanoTime();
            boolean contains = myList.contains(searchFor);
            long endContainsTime = System.nanoTime();
            long durationContains = (endContainsTime - startContainsTime) / 1000; // Convert to microseconds
            System.out.println("Time taken to search for element (" + searchFor + "): " + durationContains + " µs, Found: " + contains);
        }
    }
}
