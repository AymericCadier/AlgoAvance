package fr.pantheonsorbonne.cri.TreeSet;

import java.util.Iterator;
import java.util.Stack;

public class StringTreeSetIterator implements Iterator<String>{
    private Noeud racine;
    private Stack<Noeud> stack;

    public StringTreeSetIterator(Noeud racine) {
        this.racine = racine;
        this.stack = new Stack<Noeud>();
        Noeud nc = this.racine;
        while (nc != null) {
            this.stack.push(nc);
            nc = nc.gauche;
        }
    }

    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

    public String next() {
        Noeud nc = this.stack.pop();
        String res = nc.data;
        if (nc.droit != null) {
            nc = nc.droit;
            while (nc != null) {
                this.stack.push(nc);
                nc = nc.gauche;
            }
        }
        return res;
    }
}
