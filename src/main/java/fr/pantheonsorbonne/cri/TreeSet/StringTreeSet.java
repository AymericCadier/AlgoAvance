package fr.pantheonsorbonne.cri.TreeSet;

import java.util.Stack;

//import javax.swing.text.html.HTMLDocument.Iterator;

public class StringTreeSet {
    Noeud racine;

    public StringTreeSet() {
        this.racine = null;
    }

    public boolean add(String s) {
        if (this.racine == null) {
            this.racine = new Noeud(s, null, null, null);
            return true;
        } else {
            return this.racine.add(s);
        }
    }

    public boolean addNonRecursif(String s) {
        Noeud nc = this.racine;
        while (nc != null) {
            int c = s.compareTo(s);
            if (c == 0) {
                return false;
            } else if (c < 0) {
                if (nc.gauche == null) {
                    nc.gauche = new Noeud(s, null, null, null);
                    return true;
                } else {
                    nc = nc.gauche;
                }
            } else {
                if (nc.droit == null) {
                    nc.droit = new Noeud(s, null, null, null);
                    return true;
                } else {
                    nc = nc.droit;
                }
            }
        }
        return false;
    }

    public boolean contains(String s) {
        if (this.racine == null) {
            return false;
        } else {
            return this.racine.cont(s);
        }
    }

    public boolean containsNonRecursif(String s) {
        Noeud nc = this.racine;
        while (nc != null) {
            int c = s.compareTo(s);
            if (c == 0) {
                return true;
            } else if (c < 0) {
                nc = nc.gauche;
            } else {
                nc = nc.droit;
            }
        }
        return false;
    }

    public String toStringProf() {
        Stack<Noeud> p = new Stack<Noeud>();
        p.push(this.racine);
        StringBuilder sb = new StringBuilder();
        while (!p.isEmpty()) {
            Noeud n = p.pop();
            if (n != null) {
                sb.append(n.data);
                sb.append(", ");
                p.push(n.droit);
                p.push(n.gauche);
            }
        }
        return sb.toString();
    }

    public String toString() {
        if (this.racine == null) {
            return "[]";
        } else {
            return "[" + this.racine.toString() + "]";
        }
    }

    public void clear() {
        this.racine = null;
    }

    public String first() {
        Noeud n = this.racine;
        while (n.gauche != null) {
            n = n.gauche;
        }
        return n.data;
    }

    public boolean isEmpty() {
        return this.racine == null;
    }

    //public boolean remove(String s) {}

    public StringTreeSetIterator iterator() {
        return new StringTreeSetIterator(this.racine);
    }

    public boolean remove(String e) {
        if (racine == null) {
            return false; // L'arbre est vide, l'élément n'est pas présent
        }

        Noeud parent = null;
        Noeud courant = racine;
        boolean isLeftChild = false;

        // Recherche de l'élément à supprimer
        while (courant != null) {
            int c = e.compareTo(courant.getData());
            if (c == 0) {
                break; // Élément trouvé
            } else {
                parent = courant;
                if (c < 0) {
                    courant = courant.getGauche();
                    isLeftChild = true;
                } else {
                    courant = courant.getDroit();
                    isLeftChild = false;
                }
            }
        }

        if (courant == null) {
            return false; // L'élément n'est pas présent dans l'arbre
        }

        // Cas où le nœud à supprimer n'a pas d'enfants
        if (courant.getGauche() == null && courant.getDroit() == null) {
            if (courant == racine) {
                racine = null;
            } else if (isLeftChild) {
                parent.setGauche(null);
            } else {
                parent.setDroit(null);
            }
        }
        // Cas où le nœud à supprimer a un seul enfant
        else if (courant.getDroit() == null) {
            if (courant == racine) {
                racine = courant.getGauche();
            } else if (isLeftChild) {
                parent.setGauche(courant.getGauche());
            } else {
                parent.setDroit(courant.getGauche());
            }
        } else if (courant.getGauche() == null) {
            if (courant == racine) {
                racine = courant.getDroit();
            } else if (isLeftChild) {
                parent.setGauche(courant.getDroit());
            } else {
                parent.setDroit(courant.getDroit());
            }
        }
        // Cas où le nœud à supprimer a deux enfants
        else {
            Noeud successor = getSuccessor(courant);
            if (courant == racine) {
                racine = successor;
            } else if (isLeftChild) {
                parent.setGauche(successor);
            } else {
                parent.setDroit(successor);
            }
            successor.setGauche(courant.getGauche());
        }

        return true;
    }

    private Noeud getSuccessor(Noeud node) {
        Noeud parentOfSuccessor = node;
        Noeud successor = node;
        Noeud current = node.getDroit();
        while (current != null) {
            parentOfSuccessor = successor;
            successor = current;
            current = current.getGauche();
        }
        if (successor != node.getDroit()) {
            parentOfSuccessor.setGauche(successor.getDroit());
            successor.setDroit(node.getDroit());
        }
        return successor;
    }

    public int size() {
        int cpt = 0;
        if (this.racine == null) {
            return 0;
        } else {
            Stack<Noeud> p = new Stack<Noeud>();
            p.push(this.racine);
            while (!p.isEmpty()) {
                Noeud n = p.pop();
                if (n != null) {
                    p.push(n.droit);
                    p.push(n.gauche);
                    cpt++;
                }
            }
            return cpt;
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
        System.out.println(set.toStringProf());
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set.contains("a"));
        System.out.println(set.first());
        set.remove("a");
        System.out.println(set.toString());
    }
}