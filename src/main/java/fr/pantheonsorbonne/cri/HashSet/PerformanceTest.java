package fr.pantheonsorbonne.cri.HashSet;

public class PerformanceTest {

    public static void main(String[] args) {
        StringHashSet set = new StringHashSet();
        final int numberOfElements = 10000; // Adjust for different volumes

        // Testing add operation
        long startTime = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            set.add("Element " + i);
        }
        long endTime = System.nanoTime();
        long durationAdd = endTime - startTime;
        System.out.println("Time taken to add " + numberOfElements + " elements: " + durationAdd + " ns");

        // Testing contains operation
        startTime = System.nanoTime();
        set.contains("Element 5000"); // Example of a contained element
        endTime = System.nanoTime();
        long durationContains = endTime - startTime;
        System.out.println("Time taken to check for an existing element: " + durationContains + " ns");

        // Testing remove operation
        startTime = System.nanoTime();
        set.remove("Element 5000"); // Removing the 5000th element as an example
        endTime = System.nanoTime();
        long durationRemove = endTime - startTime;
        System.out.println("Time taken to remove an element: " + durationRemove + " ns");
    }
}
