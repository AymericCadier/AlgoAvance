package fr.pantheonsorbonne.cri.LinkedList;

public class StringLinkedList {

    Noeud debut;

    public boolean add(String s) {
        Noeud courant = this.debut;
        while (courant.getSuivant() != null) {
            courant = courant.getSuivant();
        }
        return true;
    }








    public void addFirst(String s) {
        Noeud first = new Noeud(s, ????); // ???? => faut le lier avec le noeud début 
        this.debut = first;
    }

    public void add(int index, String s) {

    }

    public void remove() {

    }
}
