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

    public String poll() {
        Noeud temp = this.debut;
        this.debut = this.debut.getSuivant();
        return temp.getData();

    }

    public void push(String s) {
        Noeud push = new Noeud(s, this.debut);
        this.debut = push;
    }

    public String remove() {
        Noeud temp = this.debut;
        this.debut = this.debut.getSuivant();
        return temp.getData();
    }

    public String removeLast() {
        Noeud courant = this.debut;
        while (courant != null) {
            if (courant.getSuivant().getSuivant() == null) {
                courant.setSuivant(null);
                return courant.getSuivant().getData();
                
            }
            courant = courant.getSuivant();
        }
        return null;

    }

    public String remove(int index) { // MARCHE PAS
        Noeud courant = this.debut;
        int nb = 0;
        while (courant != null) {
            if (nb - 1 == index) {
                courant.setSuivant(courant.getSuivant().getSuivant());
                return courant.getSuivant().getData();
            }
            nb++;
            courant = courant.getSuivant();
        }
        return null;
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
        liste.offer("OFFER");
        System.out.println(liste.toString());
        System.out.println(liste.poll());
        System.out.println(liste.toString());
        liste.push("PUSH");
        System.out.println(liste.toString());
        System.out.println(liste.remove());
        System.out.println(liste.toString());
        System.out.println(liste.removeLast());



        liste.clear();
        liste.add("Premier");
        liste.add("Deuxième");
        liste.add("Troisième");
        liste.add("Quatrième");
        liste.add("Cinquième");
        liste.add("Sixième");
        System.out.println(liste.toString());
        System.out.println(liste.remove(5)); // MARCHE PAS
        System.out.println(liste.toString());
    }
}
