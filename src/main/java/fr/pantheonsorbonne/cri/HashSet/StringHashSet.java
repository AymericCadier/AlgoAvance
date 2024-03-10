package fr.pantheonsorbonne.cri.HashSet;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class StringHashSet {
    LinkedList<Couple>[] data;
    public static int size = 0;
    static final float t = 0.7f;

    public StringHashSet() {
        data = new LinkedList[3];
    }

    public boolean add(String s) {
        grow();
        int h = s.hashCode();
        int i = Math.abs(h % data.length);
        if (data[i] == null) {
            data[i] = new LinkedList<Couple>();
        }
        for (Couple c : data[i]) {
            if (c.getS().equals(s)) {
                return false;
            }
        }
        data[i].add(new Couple(s, h));
        size++;
        return true;
    }

    public boolean contains(String s) {
        int h = s.hashCode();
        int i = Math.abs(h % data.length);
        if (data[i] == null) {
            return false;
        }
        for (Couple c : data[i]) {
            if (c.getS().equals(s)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(String s) {
        int h = s.hashCode();
        int i = Math.abs(h % data.length);
        if (data[i] == null) {
            return false;
        }
        for (Couple c : data[i]) {
            if (c.getS() .equals(s)) {
                data[i].remove(c);
                size--;
                return true;
            }
        }
        return false;
    }

    public void grow() {
        
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

    public static int size() {
        return size;
    }

    public static void main(String[] args) {
        StringHashSet set = new StringHashSet();
        long duration = 0;
        for (long i=0; i< 10000; i++){
            int j = new Random().nextInt(0, 10000);
            long startTime = System.nanoTime();
            set.add("?"+j);
            long endTime = System.nanoTime();
            duration += (endTime - startTime);
        }
        double totalduration = duration/10000d;
        System.out.println(size());
        System.out.println("Temps d'exécution de la méthode : " + totalduration + " nanosecondes");

        

    }
}
