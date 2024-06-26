package fr.pantheonsorbonne.cri.LinkedList;

import java.util.Iterator;
import java.util.Random;

import fr.pantheonsorbonne.cri.HashSet.StringHashSet;

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

    public void add(int index, String slement){
        Noeud courant = this.debut;
        int i = 0;
        while (courant != null) {
            if (i == index) {
                Noeud noeud = new Noeud(slement, courant.getSuivant());
                courant.setSuivant(noeud);
            }
            i++;
            courant = courant.getSuivant();
        }
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

    public void clear() {
        this.debut = null;
    }


    public boolean contains(Object o){
        Noeud courant = this.debut;
        while (courant != null) {
            if (courant.getData().equals(o)) {
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
        if (this.debut == null) {
            return null;
        }    
        Noeud courant = this.debut;
        Noeud precedent = null;
        while (courant.getSuivant() != null) {
            precedent = courant;
            courant = courant.getSuivant();
        }    
        if (precedent == null) {
            this.debut = null;
        } else {
            precedent.setSuivant(null);
        }    
        return courant.getData();
    }
    
    public String remove(int index) {
        if (index < 0 || this.debut == null) {
            return null;
        }    
        if (index == 0) {
            Noeud temp = this.debut;
            this.debut = this.debut.getSuivant();
            return temp.getData();
        }    
        Noeud courant = this.debut;
        int nb = 0;
        while (courant != null && nb < index - 1) {
            courant = courant.getSuivant();
            nb++;
        }    
        if (courant == null || courant.getSuivant() == null) {
            return null;
        }
        Noeud temp = courant.getSuivant();
        courant.setSuivant(courant.getSuivant().getSuivant());
        return temp.getData();
    }

    // public void remove(int index) {
    //     if (index < 0 || this.debut == null) {
    //         return;
    //     }    
    //     if (index == 0) {
    //         this.debut = this.debut.getSuivant();
    //         return;
    //     }    
    //     Noeud courant = this.debut;
    //     int nb = 0;
    //     while (courant != null && nb < index - 1) {
    //         courant = courant.getSuivant();
    //         nb++;
    //     }    
    //     if (courant == null || courant.getSuivant() == null) {
    //         return;
    //     }
    //     courant.setSuivant(courant.getSuivant().getSuivant());
    // }
    

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

    public int size() {
        Noeud courant = this.debut;
        int i = 0;
        while (courant != null) {
            i++;
            courant = courant.getSuivant();
        }
        return i;
    }

    public void  set(int index, String element) {
        Noeud courant = this.debut;
        int i = 0;
        while (courant != null) {
            if (i == index) {
                courant.setData(element);
            }
            i++;
            courant = courant.getSuivant();
        }
    }

    public boolean contains2(String s) {
        if (this.debut == null) {
            return false;
        } else {
            return this.debut.cont(s);
        }
    }

    public boolean add2(String s) {
        if (this.debut == null) {
            Noeud noeud = new Noeud(s, null);
            this.debut = noeud;
            return true;
        } else {
            return this.debut.ad(s);
        }
    }

    public static void main(String[] args) {
        StringLinkedList set = new StringLinkedList();
        long duration = 0;
        for (long i=0; i< 20000; i++){
            int j = new Random().nextInt(0, 20000);
            long startTime = System.nanoTime();
            set.add("?"+j);
            long endTime = System.nanoTime();
            duration += (endTime - startTime);
        }
        double totalduration = duration/20000d;
        System.out.println(set.size());
        System.out.println("Temps d'exécution de la méthode : " + totalduration + " nanosecondes");
    }
}
