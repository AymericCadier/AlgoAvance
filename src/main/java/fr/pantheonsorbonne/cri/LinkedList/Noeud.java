package fr.pantheonsorbonne.cri.LinkedList;

public class Noeud {
    String data;
    Noeud suivant;

    public Noeud(String data, Noeud suivant) {
        this.data = data;
        this.suivant = suivant;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Noeud getSuivant() {
        return suivant;
    }

    public void setSuivant(Noeud suivant) {
        this.suivant = suivant;
    }

    public boolean cont(String s) {
        if (this.getData() == s) {
            return true;
        } else if (this.getSuivant() == null) {
            return false;
        } else {
            return this.getSuivant().cont(s);
        }
    }

    public boolean ad(String s) {
        if (this.getSuivant() == null) {
            Noeud noeud = new Noeud(s, null);
            this.setSuivant(noeud);
            return true;
        } else {
            return this.getSuivant().ad(s);
        }
    }
}
