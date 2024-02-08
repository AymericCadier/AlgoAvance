package fr.pantheonsorbonne.cri.TreeSet;

import java.util.Stack;

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

    public boolean addNonRecursif(String s) {
        Noeud nc = this.racine;
        while (nc != null) {
            int c = s.compareTo(s);
            if (c == 0) {
                return false;
            } else if (c < 0) {
                if (nc.gauche == null) {
                    nc.gauche = new Noeud(s, null, null);
                    return true;
                } else {
                    nc = nc.gauche;
                }
            } else {
                if (nc.droit == null) {
                    nc.droit = new Noeud(s, null, null);
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