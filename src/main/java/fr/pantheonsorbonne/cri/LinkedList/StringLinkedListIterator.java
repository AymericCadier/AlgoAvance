package fr.pantheonsorbonne.cri.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringLinkedListIterator implements Iterator<String>{

    Noeud debut;

    public StringLinkedListIterator(Noeud debut) {
        this.debut = debut;
    }

    @Override
        public boolean hasNext() {
            return debut != null;
        }


        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String data = debut.getData();
            debut = debut.getSuivant();
            return data;
        }
    
}
