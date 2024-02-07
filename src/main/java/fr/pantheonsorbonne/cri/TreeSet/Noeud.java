package fr.pantheonsorbonne.cri.TreeSet;

public class Noeud {
    
    String data;
    Noeud gauche;
    Noeud droit;

    public Noeud(String data, Noeud gauche, Noeud droit) {
        this.data = data;
        this.gauche = gauche;
        this.droit = droit;
    }

    public String getData() {
        return this.data;
    }
    public Noeud getGauche() {
        return this.gauche;
    }
    public Noeud getDroit() {
        return this.droit;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setGauche(Noeud gauche) {
        this.gauche = gauche;
    }
    public void setDroit(Noeud droit) {
        this.droit = droit;
    }
    
}
