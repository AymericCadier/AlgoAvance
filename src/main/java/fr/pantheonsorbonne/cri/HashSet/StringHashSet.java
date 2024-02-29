package fr.pantheonsorbonne.cri.HashSet;

import java.util.List;

public class StringHashSet {
    List<Couple>[] data;
    int size = 0;
    static final float t = 0.7f;

    boolean add(String s) {
        int h = s.hashCode();
        int i = h % data.length;
        if (data[i] == null) {
            data[i] = new List<Couple>();
        }
        for (Couple c : data[i]) {
            if (c.s.equals(s)) {
                return false;
            }
        }
        data[i].add(new Couple(s, h));
        size++;
        if (size > t * data.length) {
            rehash();
        }
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


}
