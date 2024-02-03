package fr.pantheonsorbonne.cri;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.ArrayList.ArrayList;
import fr.pantheonsorbonne.cri.LinkedList.StringLinkedList;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

class StringLinkedListTest {

    @Test
    void testAdd() {
        StringLinkedList list = new StringLinkedList();
        assertTrue(list.add("First"));
        assertTrue(list.add("Second"));
        assertTrue(list.add("Third"));
        assertEquals("FirstSecondThird", list.toString());
    }

    @Test
    void testAddFirst() {
        StringLinkedList list = new StringLinkedList();
        list.add("Second");
        list.addFirst("First");
        assertEquals("FirstSecond", list.toString());
    }

    @Test
    void testGet() {
        StringLinkedList list = new StringLinkedList();
        list.add("First");
        list.add("Second");
        list.add("Third");
        assertEquals("Second", list.get(1));
        assertEquals("erreur", list.get(5));
    }

    @Test
    void testClear() {
        StringLinkedList list = new StringLinkedList();
        list.add("First");
        list.add("Second");
        list.clear();
        assertTrue(list.toString().isEmpty());
    }

    @Test
    void testContains() {
        StringLinkedList list = new StringLinkedList();
        list.add("First");
        list.add("Second");
        assertTrue(list.Contains("First"));
        assertFalse(list.Contains("Third"));
    }

    @Test
    void testGetFirst() {
        StringLinkedList list = new StringLinkedList();
        list.add("First");
        list.add("Second");
        assertEquals("First", list.getFirst());
    }

    @Test
    void testGetLast() {
        StringLinkedList list = new StringLinkedList();
        list.add("First");
        list.add("Second");
        assertEquals("Second", list.getLast());
    }

    @Test
    void testRemove() {
        StringLinkedList list = new StringLinkedList();
        list.add("First");
        list.add("Second");
        list.add("Third");
        assertEquals("First", list.remove());
        assertEquals("SecondThird", list.toString());
    }

    @Test
    void testPush() {
        StringLinkedList list = new StringLinkedList();
        list.add("Second");
        list.push("First");
        assertEquals("FirstSecond", list.toString());
    }

    @Test
    void testPoll() {
        StringLinkedList list = new StringLinkedList();
        list.add("First");
        list.add("Second");
        assertEquals("First", list.poll());
        assertEquals("Second", list.toString());
    }

    @Test
    void testRemoveLast() {
        StringLinkedList list = new StringLinkedList();
        assertEquals(null, list.removeLast());
        list.add("First");
        list.add("Second");
        list.add("Third");
        assertEquals("Third", list.removeLast());
        assertEquals("FirstSecond", list.toString());
    }

    @Test
    void testRemoveIndex() {
        StringLinkedList list = new StringLinkedList();
        list.add("First");
        list.add("Second");
        list.add("Third");
        assertEquals("FirstSecondThird", list.toString());
        list.remove(1);
        assertEquals("FirstThird", list.toString());
    }

    @Test
    void testOffer() {
        StringLinkedList list = new StringLinkedList();
        assertTrue(list.offer("First"));
        assertTrue(list.offer("Second"));
        assertEquals("FirstSecond", list.toString());
    }

    @Test
    void testSet() {
        StringLinkedList list = new StringLinkedList();
        list.add("First");
        list.add("Second");
        list.add("Third");
        list.set(1, "New");
        assertEquals("FirstNewThird", list.toString());
    }

    @Test
    void testSize() {
        StringLinkedList list = new StringLinkedList();
        list.add("First");
        list.add("Second");
        list.add("Third");
        assertEquals(3, list.size());
    }

}
