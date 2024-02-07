package fr.pantheonsorbonne.cri.TreeSet;

public class StringTreeSet {
    Noeud racine;

    public StringTreeSet() {
        this.racine = null;
    }

    public boolean add(String s) {
        if (this.racine == null) {
            this.racine = new Noeud(s, null, null);
            return true;
        } else {
            return this.racine.add(s);
        }
    }

    public boolean contains(String s) {
        if (this.racine == null) {
            return false;
        } else {
            return this.racine.cont(s);
        }
    }

    public String toString() {
        if (this.racine == null) {
            return "[]";
        } else {
            return "[" + this.racine.toString() + "]";
        }
    }


    public static void main(String[] args) {
        StringTreeSet set = new StringTreeSet();
        set.add("a");
        set.add("y");
        set.add("m");
        set.add("e");
        set.add("r");
        set.add("i");
        set.add("c");
        System.out.println(set.toString());
    }
}