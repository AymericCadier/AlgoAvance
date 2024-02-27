package fr.pantheonsorbonne.cri.RedAndBlack;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;


public class RedBlackTree<E extends Comparable<E>> implements Iterable<E> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private Node root;
    private int size = 0;

    private class Node {
        E value;
        Node left, right, parent;
        boolean color = BLACK;

        Node(E value, boolean color, Node parent) {
            this.value = value;
            this.color = color;
            this.parent = parent;
        }
    }

    public boolean add(E value) {
        Node parent = null;
        Node current = root;
        while (current != null) {
            int cmp = value.compareTo(current.value);
            if (cmp == 0) {
                return false; // This tree does not allow duplicate values
            } else if (cmp < 0) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }
        Node newNode = new Node(value, RED, parent);
        if (parent == null) {
            root = newNode;
        } else if (value.compareTo(parent.value) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        fixAfterInsertion(newNode);
        size++;
        return true;
    }

    private void fixAfterInsertion(Node x) {
        x.color = RED;
        while (x != null && x != root && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                Node uncle = rightOf(parentOf(parentOf(x)));
                if (colorOf(uncle) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(uncle, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateRight(parentOf(parentOf(x)));
                }
            } else {
                Node uncle = leftOf(parentOf(parentOf(x)));
                if (colorOf(uncle) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(uncle, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        root.color = BLACK;
    }

    public boolean remove(E value) {
        Node nodeToRemove = findNode(value, root);
        if (nodeToRemove == null) {
            return false; // Element not found
        }

        if (nodeToRemove.left != null && nodeToRemove.right != null) {
            Node successor = minimum(nodeToRemove.right);
            nodeToRemove.value = successor.value;
            nodeToRemove = successor;
        }

        Node replacement = (nodeToRemove.left != null) ? nodeToRemove.left : nodeToRemove.right;
        if (replacement != null) {
            replacement.parent = nodeToRemove.parent;
            if (nodeToRemove.parent == null) root = replacement;
            else if (nodeToRemove == nodeToRemove.parent.left) nodeToRemove.parent.left = replacement;
            else nodeToRemove.parent.right = replacement;

            nodeToRemove.left = nodeToRemove.right = nodeToRemove.parent = null;

            if (nodeToRemove.color == BLACK) fixAfterRemoval(replacement);
        } else if (nodeToRemove.parent == null) { // Case of root but no children
            root = null;
        } else { // No children
            if (nodeToRemove.color == BLACK) fixAfterRemoval(nodeToRemove);

            if (nodeToRemove.parent != null) {
                if (nodeToRemove == nodeToRemove.parent.left) nodeToRemove.parent.left = null;
                else if (nodeToRemove == nodeToRemove.parent.right) nodeToRemove.parent.right = null;
                nodeToRemove.parent = null;
            }
        }
        size--;
        return true;
    }

    private void fixAfterRemoval(Node x) {
        while (x != root && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {
                Node sib = rightOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateLeft(parentOf(x));
                    sib = rightOf(parentOf(x));
                }

                if (colorOf(leftOf(sib)) == BLACK && colorOf(rightOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(rightOf(sib)) == BLACK) {
                        setColor(leftOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateRight(sib);
                        sib = rightOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(sib), BLACK);
                    rotateLeft(parentOf(x));
                    x = root;
                }
            } else {
                Node sib = leftOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateRight(parentOf(x));
                    sib = leftOf(parentOf(x));
                }

                if (colorOf(rightOf(sib)) == BLACK && colorOf(leftOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(sib)) == BLACK) {
                        setColor(rightOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateLeft(sib);
                        sib = leftOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(sib), BLACK);
                    rotateRight(parentOf(x));
                    x = root;
                }
            }
        }
        setColor(x, BLACK);
    }

    private void rotateLeft(Node x) {
        if (x != null) {
            Node y = x.right;
            x.right = y.left;
            if (y.left != null) {
                y.left.parent = x;
            }
            y.parent = x.parent;
            if (x.parent == null) {
                this.root = y;
            } else if (x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
            y.left = x;
            x.parent = y;
        }
    }
    
    private void rotateRight(Node x) {
        if (x != null) {
            Node y = x.left;
            x.left = y.right;
            if (y.right != null) {
                y.right.parent = x;
            }
            y.parent = x.parent;
            if (x.parent == null) {
                this.root = y;
            } else if (x == x.parent.right) {
                x.parent.right = y;
            } else {
                x.parent.left = y;
            }
            y.right = x;
            x.parent = y;
        }
    }

    private boolean colorOf(Node n) {
        return n == null ? BLACK : n.color;
    }
    
    private Node parentOf(Node n) {
        return n == null ? null : n.parent;
    }
    
    private Node leftOf(Node n) {
        return n == null ? null : n.left;
    }
    
    private Node rightOf(Node n) {
        return n == null ? null : n.right;
    }
    
    private void setColor(Node n, boolean color) {
        if (n != null) {
            n.color = color;
        }
    }

    private Node findNode(E value, Node node) {
        while (node != null) {
            int cmp = value.compareTo(node.value);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node; // Node found
            }
        }
        return null; // Node not found
    }
    
    private Node minimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private void replaceNodeInParent(Node oldNode, Node newNode) {
        if (oldNode.parent == null) {
            root = newNode;
        } else if (oldNode == oldNode.parent.left) {
            oldNode.parent.left = newNode;
        } else if (oldNode == oldNode.parent.right) {
            oldNode.parent.right = newNode;
        }
        if (newNode != null) {
            newNode.parent = oldNode.parent;
        }
    }
    public boolean contains(Object o) {
        @SuppressWarnings("unchecked")
        E value = (E) o;
        return findNode(value, root) != null;
    }

    public E first() {
    if (root == null) throw new NoSuchElementException("The RedBlackTree is empty.");
    return minimum(root).value;
}

public Iterator<E> iterator() {
    return new Iterator<E>() {
        Stack<Node> stack = new Stack<>();

        {
            pushLeftChildren(root);
        }

        private void pushLeftChildren(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node node = stack.pop();
            E result = node.value;
            if (node.right != null) {
                pushLeftChildren(node.right);
            }
            return result;
        }
    };
}


public boolean isEmpty() {
    return root == null;
}

public int size() {
    return size;
}

public void clear() {
    root = null;
    size = 0;
}


}
