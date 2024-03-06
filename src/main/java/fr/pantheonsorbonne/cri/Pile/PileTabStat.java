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
public class PileTabStat<E> implements Pile<E>{
    protected E []t;
    protected int sp;
    
    public PileTabStat(int taille){
        t = (E[]) new Object [taille];
        sp = 0;
    }

    @Override
    public boolean empiler(E elem) {
        if(sp>=t.length){
            return false;
        }
        t[sp++]=elem;
        return true;
    }

    @Override
    public E depiler() {
        if(estVide()){
            return null;
        }
        return t[--sp];
    }

    @Override
    public E sommet() {
        if(estVide()){
            return null;
        }
        return t[sp-1];
    }

    @Override
    public boolean estVide() {
        return (sp==0);
    }

    @Override
    public int nbElem() {
        return sp;
    }
}
