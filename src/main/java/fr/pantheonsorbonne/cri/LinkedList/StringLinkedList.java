package fr.pantheonsorbonne.cri.LinkedList;

public class StringLinkedList {

    Noeud debut;

    public StringLinkedList() {
        Noeud first = new Noeud(null, null);
        debut = first;
    }

    public boolean add(String s) {
        Noeud courant = this.debut;
        if (courant.getData() == null) {
            courant.setData(s);
            courant.setSuivant(null);
        } else {
            while (courant.getSuivant() != null) {
                courant = courant.getSuivant();
            }
            Noeud noeud = new Noeud(s, null);
            courant.setSuivant(noeud);
        }
        return true;
    }

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

    boolean Contains(Object O){
        Noeud courant = this.debut;
        while (courant.getSuivant() != null) {
            if (courant.getData() == O) {
                return true;
            }
            courant = courant.getSuivant();
        }
        return false;
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
        StringLinkedList link = new StringLinkedList();
        link.add("test");
        link.add("test1");
        link.add("test2");
        System.out.println(link.toString());
        link.addFirst("first");
        System.out.println(link.toString());
    }

}
