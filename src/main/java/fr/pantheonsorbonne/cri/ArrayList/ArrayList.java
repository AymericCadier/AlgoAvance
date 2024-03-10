package fr.pantheonsorbonne.cri.ArrayList;

import java.util.Iterator;
import java.util.Random;

import fr.pantheonsorbonne.cri.HashSet.StringHashSet;
import fr.pantheonsorbonne.cri.LinkedList.StringLinkedList;

public class ArrayList {

    String[] data;
    int nb;

    public ArrayList() {
        this.data = new String[4];
        this.nb = 0;
    }

    public boolean add(String s) {
        ensureCapacity(this.nb + 1);
        if (s != null) {
            this.data[nb] = s;
            nb++;
            for (String i : this.data) {

                if (i == s) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * public boolean add(String s) {
     * ensureCapacity(this.nb + 1);
     * this.data[nb] = s;
     * nb++;
     * return true;
     * }
     */

    public void add(int index, String elem) {

        ensureCapacity(this.nb + 1);
        for (int i = nb; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = elem;
    }

    public boolean contains(String s) {
        for (String i : data) {
            if (i != null) {
                if (i.equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void ensureCapacity(int n) {
        if (n <= this.data.length) {
            return;
        }
        String[] tab2 = new String[2 * this.data.length];
        for (int i = 0; i < this.data.length; i++) {
            tab2[i] = this.data[i];
        }
        this.data = tab2;
    }

    public String get(int i) {
        if (i >= 0 && i < data.length) {
            return this.data[i];
        }
        return "erreur";
    }

    public int indexOf(String element) {
        for (int i = 0; i <= data.length; i++) {
            if (data[i].equals(element)) {
                return i;
            }

        }
        return -1;
    }

    public boolean isEmpty() {
        return this.nb == 0;
    }

    public String remove(int index) {
        String temp = data[index];

        for (int i = index; i < nb - 1; i++) {
            data[i] = data[i + 1];
        }
        data[nb - 1] = null;
        nb--;

        return temp;
    }

    public String set(int index, String element) {
        String temp = this.data[index];
        this.data[index] = element;
        return temp;
    }

    public int size() {
        return this.nb;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String i : data) {
            if (i != null)
                sb.append(i);
        }
        return sb.toString();
    }
    
    void affiche() {
        for(String e : this.data) {
            System.out.println(e);
        }
    }

    public Iterator<String> iterator() {
        return new ArraylistIterator(data);
    }

    public static void main(String[] args) {
        ArrayList set = new ArrayList();
        long duration = 0;
        for (long i=0; i< 10000; i++){
            int j = new Random().nextInt(0, 10000);
            long startTime = System.nanoTime();
            set.add("?"+j);
            long endTime = System.nanoTime();
            duration += (endTime - startTime);
        }
        double totalduration = duration/10000d;
        System.out.println(set.size());
        System.out.println("Temps d'exécution de la méthode : " + totalduration + " nanosecondes");
    

        // ArrayList alist = new ArrayList();

        // System.out.println(alist.toString());

        // for (int i = 0; i < 12; i++) {
        //     alist.ajout("test" + i);
        // }
        // alist.affiche();
        // System.out.println(alist.toString());

        // System.out.println(alist.get(5));

        // alist.add(5, "TestADD");

        // System.out.println(alist.toString());

        // System.out.println(alist.contains("test1"));

        // System.out.println(alist.indexOf("test1"));
        // alist.remove(0);
        // System.out.println(alist.toString());
        // alist.set(0, "TestSET");
        // System.out.println(alist.toString());
    }
}