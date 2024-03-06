package fr.pantheonsorbonne.cri.Pile;

public class Main {
    public static void main(String[] args) {
        StackArray stackArray = new StackArray(10);
        StackChain stackChain = new StackChain();

        for (int i = 0; i < 10; i++) {
            stackArray.push(i);
            stackChain.push(i);
        }

        System.out.println("StackArray: ");
        while (!stackArray.isEmpty()) {
            System.out.println(stackArray.pop());
        }

        System.out.println("StackChain: ");
        while (!stackChain.isEmpty()) {
            System.out.println(stackChain.pop());
        }
    }
}
