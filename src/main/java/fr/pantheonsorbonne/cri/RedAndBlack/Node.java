package fr.pantheonsorbonne.cri.RedAndBlack;


public class Node<E> {
    E value;
    Node<E> left;
    Node<E> right;
    Node<E> parent;
    boolean color;

    // Constructor for Node
    public Node(E value, boolean color, Node<E> parent) {
        this.value = value;
        this.color = color;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }


    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }
}
