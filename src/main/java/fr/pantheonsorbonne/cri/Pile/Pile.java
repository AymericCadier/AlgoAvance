/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.pantheonsorbonne.cri.Pile;

/**
 *
 * @author lenal
 */
public interface Pile<E> {
    boolean empiler(E elem); //retourne true si ok
    E depiler();
    E sommet();
    boolean estVide();
    int nbElem();
}
