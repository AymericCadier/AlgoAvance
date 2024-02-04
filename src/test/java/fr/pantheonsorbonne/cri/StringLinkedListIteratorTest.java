package fr.pantheonsorbonne.cri;

import fr.pantheonsorbonne.cri.LinkedList.Noeud;
import fr.pantheonsorbonne.cri.LinkedList.StringLinkedListIterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StringLinkedListIteratorTest {

    private Noeud node1, node2, node3;
    private StringLinkedListIterator iterator;

    @BeforeEach
    public void setUp() {
        // Create a linked list: "node1" -> "node2" -> "node3"
        node1 = new Noeud("node1", node2);
        node2 = new Noeud("node2", node3);
        node3 = new Noeud("node3", null);

        node1.setSuivant(node2);
        node2.setSuivant(node3);

        iterator = new StringLinkedListIterator(node1);
    }

    @Test
    public void testHasNext() {
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testNext() {
        assertEquals("node1", iterator.next());
        assertEquals("node2", iterator.next());
        assertEquals("node3", iterator.next());
    }

}
