package fr.pantheonsorbonne.cri.RedAndBlack;


public class Main {
    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<>();

        System.out.println("Adding elements...");
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);

        System.out.println("Current tree size: " + tree.size());

        System.out.println("Does the tree contain 3? " + tree.contains(3));
        System.out.println("Does the tree contain 10? " + tree.contains(10));

        System.out.println("First element (smallest): " + tree.first());

        System.out.println("Iterating over elements:");
        for (Integer value : tree) {
            System.out.println(value);
        }

        System.out.println("Removing element 3...");
        tree.remove(3);
        System.out.println("Does the tree contain 3? " + tree.contains(3));

        System.out.println("Current tree size: " + tree.size());
        System.out.println("Is the tree empty? " + tree.isEmpty());
    }
}
