package fr.pantheonsorbonne.cri.HashSet;

import java.util.LinkedList;
import java.util.List;

public class StringHashSet {
    LinkedList<Couple>[] data;
    int size = 0;
    static final float t = 0.7f;

    public StringHashSet() {
        data = new LinkedList[3];
    }

    boolean add(String s) {
        grow();
        int h = s.hashCode();
        int i = Math.abs(h % data.length);
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
        return true;
    }

    boolean contains(String s) {
        int h = s.hashCode();
        int i = Math.abs(h % data.length);
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
            System.out.println("Growing");
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
        set.add("salut");
        set.add("je");
        set.add("appelle");
        set.add("Adorien");
        set.add("HITDIER");

        System.out.println("Current set size: " + set.size);
        System.out.println(set.contains("salut"));
        System.out.println(set.contains("je"));
        System.out.println(set.contains("plugh"));
        System.out.println(set.contains("appelle"));
        System.out.println(set.contains("aymx"));
        System.out.println(set.contains("frobozz"));
    }
}
