package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.RedAndBlack.RedBlackTree;

public class RedAndBlackTest {

    private RedBlackTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new RedBlackTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
    }

    @Test
    void testContains() {
        assertTrue(tree.contains(3), "Tree should contain 3.");
        assertFalse(tree.contains(10), "Tree should not contain 10.");
    }

    @Test
    void testSize() {
        assertEquals(7, tree.size(), "Tree size should be 7.");
    }

    @Test
    void testFirst() {
        assertEquals(2, tree.first(), "The first element should be 2.");
    }

    @Test
    void testRemove() {
        assertTrue(tree.remove(3), "Should be able to remove 3.");
        assertFalse(tree.contains(3), "Tree should not contain 3 after removal.");
        assertEquals(6, tree.size(), "Tree size should be 6 after removal.");
    }

    @Test
    void testClear() {
        assertFalse(tree.isEmpty(), "Tree should not be empty before clearing.");
        tree.clear();
        assertTrue(tree.isEmpty(), "Tree should be empty after clearing.");
        assertEquals(0, tree.size(), "Tree size should be 0 after clearing.");
    }


    
}
