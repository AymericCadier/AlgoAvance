package fr.pantheonsorbonne.cri.LinkedList;

public class StringLinkedList {

    Noeud debut;

    public StringLinkedList() {
        Noeud first = new Noeud(null, null);
        debut = first;
    }

    public boolean add(String s) {
        Noeud courant = this.debut;
        while (courant.getSuivant() != null) {
            courant = courant.getSuivant();
        }
        Noeud noeud = new Noeud(s,null);
        courant.setSuivant(noeud);
        return true;
    }

    public void addFirst(String s) {
        Noeud first = new Noeud(s, this.debut);
        this.debut = first;
    }

    public String toString(){
        String s = "";
        Noeud courant = this.debut;
        while (courant.getSuivant() != null) {
            s += courant.getData();
            courant = courant.getSuivant();
        }
        return s;
    }
/* 
    public void affiche() {
        Noeud courant = this.debut;
    }
*/

/* 
    public void add(int index, String s) {

    }

    public void remove() {

    }
*/

    public static void main(String[] args) {
        StringLinkedList link = new StringLinkedList();
        link.add("test");
        link.add("test1");
        link.add("test2");
        link.addFirst("first");
    }

}
