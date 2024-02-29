package fr.pantheonsorbonne.cri.HashSet;

import java.util.LinkedList;
import java.util.List;

public class StringHashSet {
    LinkedList<Couple>[] data;
    int size = 0;
    static final float t = 0.7f;

    public StringHashSet() {
        data = new LinkedList[16];
    }

    boolean add(String s) {
        int h = s.hashCode();
        int i = h % data.length;
        if (data[i] == null) {
            data[i] = new LinkedList<Couple>();
        }
        for (Couple c : data[i]) {
            if (c.s.equals(s)) {
                return false;
            }
        }
        data[i].add(new Couple(s, h));
        size++;
        grow();
        return true;
    }

    boolean contains(String s) {
        int h = s.hashCode();
        int i = h % data.length;
        if (data[i] == null) {
            return false;
        }
        for (Couple c : data[i]) {
            if (c.s.equals(s)) {
                return true;
            }
        }
        return false;
    }

    void grow() {
        if (size / data.length > t) {
            List<Couple>[] old = data;
            data = new LinkedList[2 * old.length];
            size = 0;
            for (List<Couple> l : old) {
                if (l != null) {
                    for (Couple c : l) {
                        add(c.s);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        StringHashSet set = new StringHashSet();
        System.out.println("Adding elements...");
        set.add("hello");
        set.add("world");
        set.add("foo");
        set.add("bar");
        set.add("baz");
        set.add("qux");
        set.add("quux");
        set.add("corge");
        set.add("grault");
        set.add("garply");
        set.add("waldo");
        set.add("fred");
        set.add("plugh");
        set.add("xyzzy");
        set.add("thud");
        System.out.println("Current set size: " + set.size);
        System.out.println("Does the set contain \"hello\"? " + set.contains("hello"));
        System.out.println("Does the set contain \"qux\"? " + set.contains("qux"));
        System.out.println("Does the set contain \"plugh\"? " + set.contains("plugh"));
        System.out.println("Does the set contain \"xyzzy\"? " + set.contains("xyzzy"));
        System.out.println("Does the set contain \"thud\"? " + set.contains("thud"));
        System.out.println("Does the set contain \"frobozz\"? " + set.contains("frobozz"));
    }

}
