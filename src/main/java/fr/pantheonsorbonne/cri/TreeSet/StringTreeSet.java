package fr.pantheonsorbonne.cri.TreeSet;

import java.util.Stack;

import javax.swing.text.html.HTMLDocument.Iterator;

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

    public boolean remove(String s) {

    }

    public Iterator<String> iterator() {
        return new StringTreeSetIterator(this.racine);
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
    }
}