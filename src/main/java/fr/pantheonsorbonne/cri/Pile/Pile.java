package fr.pantheonsorbonne.cri.Pile;


public interface Pile<E> {
    boolean empiler(E elem); //retourne true si ok
    E depiler();
    E sommet();
    boolean estVide();
    int nbElem();
}
