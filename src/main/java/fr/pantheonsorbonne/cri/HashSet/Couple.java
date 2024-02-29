package fr.pantheonsorbonne.cri.HashSet;

public class Couple {
    String s;
    int hash;

    public Couple(String s, int hash) {
        this.s = s;
        this.hash = hash;
    }

    public boolean setS(String s) {
        this.s = s;
        this.hash = s.hashCode();
        return true;
    }

    public String getS() {
        return this.s;
    }

    public int getHash() {
        return this.hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }
}
