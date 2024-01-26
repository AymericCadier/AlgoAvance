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

    public String getSuivant() {
        return suivant.getData();
    }

    public void setSuivant(Noeud suivant) {
        this.suivant = suivant;
    }
   
}
