package fr.pantheonsorbonne.cri.Pile;

import java.util.Iterator;
import fr.pantheonsorbonne.cri.Pile.StackChainIterator;

public class StackChain implements Iterable<Integer>{
    private Node top;
    private int size;

    public StackChain() {
        top = null;
        size = 0;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {
        if (top == null) {
            return -1;
        }
        int data = top.data;
        top = top.next;
        size--;
        return data;
    }
        // Existing code...

        @Override
        public Iterator<Integer> iterator() {
            return new StackChainIterator();
        }
}
