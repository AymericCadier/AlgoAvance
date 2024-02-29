package fr.pantheonsorbonne.cri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.HashSet.StringHashSet;

public class HashSetTest {
      @Test
    public void testAdd() {
        StringHashSet set = new StringHashSet();
        Assertions.assertTrue(set.add("hello"));
        // Adding the same string should return false
        Assertions.assertFalse(set.add("hello"));
    }

    @Test
    public void testContains() {
        StringHashSet set = new StringHashSet();
        set.add("world");
        Assertions.assertTrue(set.contains("world"));
        Assertions.assertFalse(set.contains("hello"));
    }

    @Test
    public void testRemove() {
        StringHashSet set = new StringHashSet();
        set.add("removeMe");
        Assertions.assertTrue(set.contains("removeMe"));
        Assertions.assertTrue(set.remove("removeMe"));
        Assertions.assertFalse(set.contains("removeMe"));
    }

    @Test
    public void testGrow() {
        StringHashSet set = new StringHashSet();
        // Assuming initial capacity is low, adding multiple items should trigger grow
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        // Verify items are still present after grow
        Assertions.assertTrue(set.contains("one"));
        Assertions.assertTrue(set.contains("two"));
        Assertions.assertTrue(set.contains("three"));
        Assertions.assertTrue(set.contains("four"));
    }

    @Test
    public void testSizeAfterOperations() {
        StringHashSet set = new StringHashSet();
        set.add("alpha");
        set.add("beta");
        set.add("gamma");
        // Remove an item and check size
        set.remove("beta");
        // Assuming the size is publicly accessible. Otherwise, use reflection or make it accessible.
        Assertions.assertEquals(2, set.size);
    }

    @Test
    public void testAddNull() {
        StringHashSet set = new StringHashSet();
        Assertions.assertThrows(NullPointerException.class, () -> set.add(null));
    }

    @Test
    public void testAddEmptyString() {
        StringHashSet set = new StringHashSet();
        Assertions.assertTrue(set.add(""));
        Assertions.assertTrue(set.contains(""));
    }

    @Test
    public void testRemoveNonExistentElement() {
        StringHashSet set = new StringHashSet();
        Assertions.assertFalse(set.remove("nonexistent"));
    }

    @Test
    public void testSizeAfterRemovingNonExistent() {
        StringHashSet set = new StringHashSet();
        set.add("test");
        set.remove("nonexistent");
        Assertions.assertEquals(1, set.size); // Assuming size is accessible
    }
}
