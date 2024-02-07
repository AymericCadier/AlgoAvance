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
            return "";
        } else {
            return this.racine.toString();
        }
    }
}
