package fr.pantheonsorbonne.cri.ArrayList;

public class PerformanceTest {

    public static void main(String[] args) {
        ArrayList myList = new ArrayList();
        final int numberOfElements = 10000; // Change this for more or fewer elements

        // Testing add operation
        long startTime = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            myList.add("Element " + i);
        }
        long endTime = System.nanoTime();
        long durationAdd = endTime - startTime;
        System.out.println("Time taken to add " + numberOfElements + " elements: " + durationAdd + " ns");

        // Testing contains operation
        startTime = System.nanoTime();
        myList.contains("Element 5000"); // Example search
        endTime = System.nanoTime();
        long durationContains = endTime - startTime;
        System.out.println("Time taken to search an element: " + durationContains + " ns");

        // Testing remove operation
        startTime = System.nanoTime();
        myList.remove(5000); // Removing the 5000th element as an example
        endTime = System.nanoTime();
        long durationRemove = endTime - startTime;
        System.out.println("Time taken to remove an element: " + durationRemove + " ns");
    }
}
