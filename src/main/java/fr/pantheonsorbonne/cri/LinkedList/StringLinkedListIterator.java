package fr.pantheonsorbonne.cri.LinkedList;

import java.util.Iterator;

public class StringLinkedListIterator implements Iterator<String>{

    Noeud debut;

    public StringLinkedListIterator(Noeud debut) {
        this.debut = debut;
    }

    @Override
    public boolean hasNext() { 
        Noeud courant = this.debut;
        while(courant != null) {
            if (courant.getSuivant() != null) {
                return true;
            }
            courant = courant.getSuivant();
        }
        return false;
    }

    @Override 
    public String next() {
        Noeud courant = this.debut;
        while(courant != null) {
            if (courant.getSuivant() != null) {
                return courant.getValeur();
            }
            courant = courant.getSuivant();
        }
        
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }
    
}
