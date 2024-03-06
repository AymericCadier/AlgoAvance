package fr.pantheonsorbonne.cri.Pile;

public class StackChainIterator {
    
    private Node first;
    private int size;
    
    public StackChainIterator() {
        first = null;
        size = 0;
    }
    
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = first;
        first = newNode;
        size++;
    }
    
    public int pop() {
        if (first == null) {
            throw new IllegalStateException("Stack is empty");
        }
        int data = first.data;
        first = first.next;
        size--;
        return data;
    }
    
    public int peek() {
        if (first == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return first.data;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public int size() {
        return size;
    }
    
    public void clear() {
        first = null;
        size = 0;
    }
    
    public void print() {
        Node current = first;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public void reverse() {
        Node prev = null;
        Node current = first;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        first = prev;
    }
    
    public void remove(int data) {
        if (first == null) {
            return;
        }
        if (first.data == data) {
            first = first.next;
            size--;
            return;
        }
        Node current = first;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }
    
    public void removeBottomHalf() {
        if (first == null) {
            return;
        }
        if (size == 1) {
            first = null;
            return;
        }
        Node prev = null;
        Node slow = first;
        Node fast = first;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        size /= 2;
    }
}
