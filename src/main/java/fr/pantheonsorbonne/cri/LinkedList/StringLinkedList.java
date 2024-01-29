package fr.pantheonsorbonne.cri.LinkedList;

import java.util.Iterator;

public class StringLinkedList {

    Noeud debut;

    public StringLinkedList() {
        this.debut = null;
    }

    public boolean add(String s) {
        Noeud noeud = new Noeud(s, null);
        if (this.debut == null) {
            this.debut = noeud;
        } else {
            Noeud courant = this.debut;
            while (courant.getSuivant() != null) {
                courant = courant.getSuivant();
            }
            courant.setSuivant(noeud);
        }
        return true;
    }
    /*
     * public boolean add2(String s) {
     * Noeud courant = this.debut;
     * if (courant.getData() == null) {
     * courant.setData(s);
     * courant.setSuivant(null);
     * } else {
     * while (courant.getSuivant() != null) {
     * courant = courant.getSuivant();
     * }
     * Noeud noeud = new Noeud(s, null);
     * courant.setSuivant(noeud);
     * }
     * return true;
     * }
     */

    public void addFirst(String s) {
        Noeud first = new Noeud(s, this.debut);
        this.debut = first;
    }

    public String get(int index) {
        Noeud courant = this.debut;
        int i = 0;
        while (courant.getSuivant() != null) {
            if (i == index) {
                return courant.getData();
            }
            courant = courant.getSuivant();
            i++;
        }
        return "erreur";
    }

    void clear() {
        this.debut = null;
    }

    boolean Contains(String s) {
        Noeud courant = this.debut;
        while (courant.getSuivant() != null) {
            if (courant.getData() == s) {
                return true;
            }
            courant = courant.getSuivant();
        }
        return false;
    }

    public String getFirst() {
        return this.debut.getData();
    }

    public String getLast() { // JSP ON PEUT MIEUX FAIRE JE PENSE
        Noeud courant = this.debut;
        while (courant != null) {
            if (courant.getSuivant().getSuivant() == null) {
                return courant.getSuivant().getData();
            }
            courant = courant.getSuivant();
        }
        return null;
    }

    public Iterator<String> iterator() {
        return new StringLinkedListIterator(this.debut);
    }

    public boolean offer(String s) {
        
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Noeud courant = this.debut;
        while (courant != null) {
            sb.append(courant.getData());
            courant = courant.getSuivant();
        }
        return sb.toString();
    }

    /*
     * public void affiche() {
     * Noeud courant = this.debut;
     * }
     */

    /*
     * public void add(int index, String s) {
     * 
     * }
     * 
     * public void remove() {
     * 
     * }
     */
    public static void main(String[] args) {

        StringLinkedList liste = new StringLinkedList();

        liste.add("Premier");
        liste.add("Deuxième");
        liste.add("Troisième");

        System.out.println(liste.toString());

        System.out.println(liste.getFirst());
        System.out.println(liste.getLast());
    }

}
