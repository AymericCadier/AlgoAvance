package fr.pantheonsorbonne.cri.RedAndBlack;

public class PerformanceTest {

    public static void main(String[] args) {
        RedBlackTree<Integer> rbTree = new RedBlackTree<>();
        final int numberOfElements = 10000; // Adjust as needed for testing

        // Testing add operation
        long startTime = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            rbTree.add(i);
        }
        long endTime = System.nanoTime();
        long durationAdd = endTime - startTime;
        System.out.println("Time taken to add " + numberOfElements + " elements: " + durationAdd + " ns");

        // Testing contains operation
        startTime = System.nanoTime();
        rbTree.contains(5000); // Example of searching for an element
        endTime = System.nanoTime();
        long durationContains = endTime - startTime;
        System.out.println("Time taken to search for an element: " + durationContains + " ns");

        // Testing remove operation
        startTime = System.nanoTime();
        rbTree.remove(5000); // Removing the element with value 5000 as an example
        endTime = System.nanoTime();
        long durationRemove = endTime - startTime;
        System.out.println("Time taken to remove an element: " + durationRemove + " ns");
    }
}
