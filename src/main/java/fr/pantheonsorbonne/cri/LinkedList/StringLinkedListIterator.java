package fr.pantheonsorbonne.cri.LinkedList;

import java.util.Iterator;

public class StringLinkedListIterator implements Iterator<String>{

    Noeud debut;

    public StringLinkedListIterator(Noeud debut) {
        this.debut = debut;
    }

    @Override
        public boolean hasNext() {
            return current != null;
        }


        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String data = current.data;
            current = current.next;
            return data;
        }
    
}
