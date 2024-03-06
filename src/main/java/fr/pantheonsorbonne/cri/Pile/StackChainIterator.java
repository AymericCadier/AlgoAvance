package fr.pantheonsorbonne.cri.Pile;

import java.util.Iterator;
import java.util.NoSuchElementException;

   

    public class StackChainIterator implements Iterator<Integer> {
        private Node current;

        public void StackIterator() {
            Node top = null; // Initialize the top variable
            current = top;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the stack");
            }
            int data = current.data;
            current = current.next;
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported");
        }
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

