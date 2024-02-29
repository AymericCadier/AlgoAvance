package fr.pantheonsorbonne.cri.HashSet;

import java.util.Random;

public class PerformanceTest {

    public static void main(String[] args) {
        StringHashSet set = new StringHashSet();
        
        // Generate a random number of elements to add
        Random random = new Random();
        int numberOfElementsToAdd = random.nextInt(1000); // For example, up to 1000 elements
        
        // Start timing
        long startTime = System.nanoTime();
        
        // Add random elements to the set
        for (int i = 0; i < numberOfElementsToAdd; i++) {
            String element = "Element" + random.nextInt();
            set.add(element);
        }
        
        // End timing
        long endTime = System.nanoTime();
        
        // Calculate elapsed time and print result
        long elapsedTime = endTime - startTime;
        double elapsedTimeInMilliseconds = elapsedTime / 1_000_000.0;
        
        System.out.println("Added " + numberOfElementsToAdd + " elements.");
        System.out.println("Execution time in milliseconds: " + elapsedTimeInMilliseconds);
    }
}
