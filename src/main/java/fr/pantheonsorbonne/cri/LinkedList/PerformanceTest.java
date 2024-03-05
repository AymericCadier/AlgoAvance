package fr.pantheonsorbonne.cri.LinkedList;

import fr.pantheonsorbonne.cri.ArrayList.ArrayList;

public class PerformanceTest {

    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
    }

    private static void testArrayList() {
        ArrayList arrayList = new ArrayList();
        final int numberOfElements = 10000; // Adjust for testing

        long startTime = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            arrayList.add("Element " + i);
        }
        long endTime = System.nanoTime();
        System.out.println("ArrayList - Time to add " + numberOfElements + " elements: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        arrayList.contains("Element 5000");
        endTime = System.nanoTime();
        System.out.println("ArrayList - Time to search for an element: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        arrayList.remove(5000);
        endTime = System.nanoTime();
        System.out.println("ArrayList - Time to remove an element: " + (endTime - startTime) + " ns");
    }

    private static void testLinkedList() {
        StringLinkedList linkedList = new StringLinkedList();
        final int numberOfElements = 10000; // Adjust for testing

        long startTime = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            linkedList.add("Element " + i);
        }
        long endTime = System.nanoTime();
        System.out.println("LinkedList - Time to add " + numberOfElements + " elements: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedList.Contains("Element 5000");
        endTime = System.nanoTime();
        System.out.println("LinkedList - Time to search for an element: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedList.remove(5000);
        endTime = System.nanoTime();
        System.out.println("LinkedList - Time to remove an element: " + (endTime - startTime) + " ns");
    }
}
