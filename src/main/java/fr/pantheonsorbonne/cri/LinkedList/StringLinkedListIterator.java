package fr.pantheonsorbonne.cri.LinkedList;

import java.util.Iterator;

public class StringLinkedListIterator implements Iterator<String>{

    Noeud debut;

    public StringLinkedListIterator(Noeud debut) {
        this.debut = debut;
    }

    @Override
    public boolean hasNext() { // jsp imo c'est bon mais on peut mieux faire
        Noeud courant = this.debut;
        while(courant != null) {
            if (courant.getSuivant() != null) {
                return true;
            }
            courant = courant.getSuivant();
        }
        return false;
    }

    @Override // jsp
    public String next() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }
    
}
