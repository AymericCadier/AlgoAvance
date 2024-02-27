package fr.pantheonsorbonne.cri.TreeSet;

public class Noeud {

    String data;
    Noeud gauche;
    Noeud droit;
    Noeud pere;
    String couleur;
    Noeud racine;

    public Noeud(String data, Noeud gauche, Noeud droit, Noeud pere, String couleur) {
        this.data = data;
        this.gauche = gauche;
        this.droit = droit;
        this.pere = pere;
        this.couleur = couleur;
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

    public String getCouleur() {
        return this.couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Noeud getRacine() {
        return this.racine;
    }

    public void setRacine(Noeud racine) {
        this.racine = racine;
    }

    
    public Noeud add(String s) {
        if (this.getData() == null) {
            this.setData(s);
            this.setCouleur("noir");
            return this;
        } else if (this.getData().compareTo(s) > 0) {
            if (this.getGauche() == null) {
                this.setGauche(new Noeud(s, null, null, this, "rouge"));
                return this.getGauche();
            } else {
                return this.getGauche().add(s);
            }
        } else {
            if (this.getDroit() == null) {
                this.setDroit(new Noeud(s, null, null, this, "rouge"));
                return this.getDroit();
            } else {
                return this.getDroit().add(s);
            }
        }
    }

    public Noeud add2(String s) {
    if (this.getData() == null) {
        this.setData(s);
        this.setCouleur("noir");
        return this;
    } else if (this.getData().compareTo(s) > 0) {
        if (this.getGauche() == null) {
            this.setGauche(new Noeud(s, null, null, this, "rouge"));
            equilibrer(this.getGauche());
        } else {
            this.getGauche().add(s);
        }
    } else {
        if (this.getDroit() == null) {
            this.setDroit(new Noeud(s, null, null, this, "rouge"));
            equilibrer(this.getDroit());
        } else {
            this.getDroit().add(s);
        }
    }
    return this;
}

    public void equilibrer(Noeud x) {
    Noeud p = x.getPere();
    if (p == null) {
        x.setCouleur("noir");
        return;
    }
    if (p.getCouleur().equals("noir")) {
        return;
    }
    Noeud g = p.getPere();
    Noeud u = g == null ? null : (g.getGauche() == p ? g.getDroit() : g.getGauche());
    if (u != null && u.getCouleur().equals("rouge")) {
        p.setCouleur("noir");
        u.setCouleur("noir");
        g.setCouleur("rouge");
        equilibrer(g);
    } else {
        if (x == p.getDroit() && p == g.getGauche()) {
            rotateLeft(p);
            x = x.getGauche();
        } else if (x == p.getGauche() && p == g.getDroit()) {
            rotateRight(p);
            x = x.getDroit();
        }
        p = x.getPere();
        g = p.getPere();
        p.setCouleur("noir");
        g.setCouleur("rouge");
        if (x == p.getGauche()) {
            rotateRight(g);
        } else {
            rotateLeft(g);
        }
    }
}

public void rotateLeft(Noeud x) {
    Noeud y = x.getDroit();
    x.setDroit(y.getGauche());
    if (y.getGauche() != null) {
        y.getGauche().setPere(x);
    }
    y.setPere(x.getPere());
    if (x.getPere() == null) {
        // x est la racine, donc on met à jour la racine.
        // Vous devrez peut-être ajuster cette partie en fonction de la façon dont vous stockez la racine de l'arbre.
        this.setRacine(y);
    } else if (x == x.getPere().getGauche()) {
        x.getPere().setGauche(y);
    } else {
        x.getPere().setDroit(y);
    }
    y.setGauche(x);
    x.setPere(y);
}

public void rotateRight(Noeud x) {
    Noeud y = x.getGauche();
    x.setGauche(y.getDroit());
    if (y.getDroit() != null) {
        y.getDroit().setPere(x);
    }
    y.setPere(x.getPere());
    if (x.getPere() == null) {
        // x est la racine, donc on met à jour la racine.
        // Vous devrez peut-être ajuster cette partie en fonction de la façon dont vous stockez la racine de l'arbre.
        this.setRacine(y);
    } else if (x == x.getPere().getDroit()) {
        x.getPere().setDroit(y);
    } else {
        x.getPere().setGauche(y);
    }
    y.setDroit(x);
    x.setPere(y);
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

    public boolean remove(String s) {
    if (this.getData() == s) {
        if (this.getGauche() == null && this.getDroit() == null) {
            if (this.getPere() != null) {
                if (this.getPere().getGauche() == this) {
                    this.getPere().setGauche(null);
                } else {
                    this.getPere().setDroit(null);
                }
            }
            return true;
        } else if (this.getGauche() == null) {
            if (this.getPere() != null) {
                if (this.getPere().getGauche() == this) {
                    this.getPere().setGauche(this.getDroit());
                } else {
                    this.getPere().setDroit(this.getDroit());
                }
            }
            return true;
        } else if (this.getDroit() == null) {
            if (this.getPere() != null) {
                if (this.getPere().getGauche() == this) {
                    this.getPere().setGauche(this.getGauche());
                } else {
                    this.getPere().setDroit(this.getGauche());
                }
            }
            return true;
        } else {
            Noeud n = this.getDroit();
            while (n.getGauche() != null) {
                n = n.getGauche();
            }
            this.setData(n.getData());
            return n.remove(n.getData());
        }
    } else if (this.getData().compareTo(s) > 0) {
        if (this.getGauche() == null) {
            return false;
        } else {
            return this.getGauche().remove(s);
        }
    } else {
        if (this.getDroit() == null) {
            return false;
        } else {
            return this.getDroit().remove(s);
        }
    }
}


}
