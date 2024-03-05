package fr.pantheonsorbonne.cri.RedAndBlack;

public class PerformanceTest {

    public static void main(String[] args) {
        RedBlackTree<Integer> rbTree = new RedBlackTree<>();
        // Expanded and more granular range of levels to test
        int[] levels = {100, 500, 1000, 5000, 10000, 20000, 50000, 100000, 100000, 500000};

        for (int level : levels) {
            // Reset the tree for each level
            rbTree.clear(); // Ensure the tree is reset for each level

            // Timing add operations
            long startAddTime = System.nanoTime();
            for (int i = 0; i < level; i++) {
                rbTree.add(i);
            }
            long endAddTime = System.nanoTime();
            double durationAdd = (endAddTime - startAddTime) / 1000d; // Convert to microseconds
            System.out.println("Time taken to add " + level + " elements: " + durationAdd + " µs");

            // For searching, use the last element added, ensuring we're testing the worst-case scenario
            long startContainsTime = System.nanoTime();
            boolean contains = rbTree.contains(level - 1); // Search for the last element added
            long endContainsTime = System.nanoTime();
            double durationContains = (endContainsTime - startContainsTime) / 1000d; // Convert to microseconds
            System.out.println("Time taken to search the last element (Element " + (level - 1) + "): " + durationContains + " µs, Found: " + contains);
        }
    }
}
