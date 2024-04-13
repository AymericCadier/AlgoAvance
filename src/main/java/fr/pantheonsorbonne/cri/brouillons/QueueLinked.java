package fr.pantheonsorbonne.cri.brouillons;

import java.util.Iterator;

public class QueueLinked implements Iterable<String> {

    private Node front;
    private Node rear;

    public static class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }

        public String getData() {
            return this.data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void add(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("La file d'attente est vide");
        }
        return front.getData();
    }

    public String poll() {
        if (isEmpty()) {
            throw new RuntimeException("La file d'attente est vide");
        }
        String data = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return data;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyQueueChainIterator();
    }

    private class MyQueueChainIterator implements Iterator<String> {
        private Node current = front;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new RuntimeException("Plus d'éléments dans la file d'attente");
            }
            String data = current.getData();
            current = current.getNext();
            return data;
        }
    }
}

