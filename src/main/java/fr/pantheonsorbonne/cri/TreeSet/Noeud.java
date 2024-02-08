package fr.pantheonsorbonne.cri.TreeSet;

public class Noeud {
    
    String data;
    Noeud gauche;
    Noeud droit;
    Noeud pere;

    public Noeud(String data, Noeud gauche, Noeud droit, Noeud pere) {
        this.data = data;
        this.gauche = gauche;
        this.droit = droit;
        this.pere = pere;
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
    public Noeud getPere() {
        return this.pere;
    }
    public void setPere(Noeud pere) {
        this.pere = pere;
    }

    public boolean add(String s) {
        if (this.getData() == s) {
            return false;
        } else if (this.getData().compareTo(s) > 0) {
            if (this.getGauche() == null) {
                this.setGauche(new Noeud(s, null, null, null));
                return true;
            } else {
                return this.getGauche().add(s);
            }
        } else {
            if (this.getDroit() == null) {
                this.setDroit(new Noeud(s, null, null, null));
                return true;
            } else {
                return this.getDroit().add(s);
            }
        }
    }

    public boolean cont(String s) {
        if (this.getData() == s) {
            return true;
        } else if (this.getData().compareTo(s) > 0) {
            if (this.getGauche() == null) {
                return false;
            } else {
                return this.getGauche().cont(s);
            }
        } else {
            if (this.getDroit() == null) {
                return false;
            } else {
                return this.getDroit().cont(s);
            }
        }
    }

    
    public String toStringProf() {
        return this.getGauche().toString() + ", " + this.getData() + ", " + this.getDroit().toString();
    }

    public String toString() {
        if (this.getGauche() == null && this.getDroit() == null) {
            return this.getData();
        } else if (this.getGauche() == null) {
            return this.getData() + ", " + this.getDroit().toString();
        } else if (this.getDroit() == null) {
            return this.getGauche().toString() + ", " + this.getData();
        } else {
            return this.getGauche().toString() + ", " + this.getData() + ", " + this.getDroit().toString();
        }
    } 

    
}
