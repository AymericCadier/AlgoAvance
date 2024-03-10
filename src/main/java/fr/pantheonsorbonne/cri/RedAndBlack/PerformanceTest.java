package fr.pantheonsorbonne.cri.RedAndBlack;

import java.util.Random;

public class PerformanceTest {

    private static final int[] iterations = {
        100, 1000, 5000, 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000,
        55000, 60000, 65000, 70000, 75000, 80000, 85000, 90000, 95000, 100000
    };

    public static void main(String[] args) {
        for (int iter : iterations) {
            RedBlackTree<Integer> tree = new RedBlackTree<>();
            long totalAddDuration = 0;
            long totalContainsDuration = 0;
            Random random = new Random();

            // Measure time to add elements to the tree
            for (int i = 0; i < iter; i++) {
                int element = random.nextInt();
                long startTime = System.nanoTime();
                tree.add(element);
                long endTime = System.nanoTime();
                totalAddDuration += (endTime - startTime);
            }

            // Measure time to check for containment of the last added element
            
            for (int i = 0; i < iter; i++) {
                long startTime = System.nanoTime();
                tree.contains(random.nextInt());
                long endTime = System.nanoTime();
                totalContainsDuration += (endTime - startTime);
            }

            double averageAddDuration = totalAddDuration / iter;
            double averageContainsDuration = totalContainsDuration / iter;

            // Display the execution time
            System.out.println("For " + iter + " iterations:");
            System.out.println("Average add time (nanoseconds): " + averageAddDuration );
            System.out.println("Average contains time (nanoseconds): " + averageContainsDuration);
            System.out.println();
        }
    }
}