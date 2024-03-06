/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td2.pile;

/**
 *
 * @author lenal
 */
public class PileListCh<E> implements Pile<E>{

    class Node {
        E elem;
        Node prec;
        
        public Node(E elem, Node prec){
            this.elem = elem;
            this.prec = prec;
        }
    }
    
    private Node top; //top==null ssi pile vide
    private int nbElem;
    
    public PileListCh(){
        top = null;
        nbElem = 0;
    }   
            
    @Override
    public boolean empiler(E elem) {
        top = new Node(elem, top);
        nbElem++;
        return true;
    }

    @Override
    public E depiler() {
        if(estVide()){
            return null;
        }
        E res = top.elem;
        top = top.prec;
        nbElem--;
        return res;
    }

    @Override
    public E sommet() {
        if(estVide()){
            return null;
        }
        return top.elem;
    }

    @Override
    public boolean estVide() {
        return (top==null);
    }

    @Override
    public int nbElem() {
        return nbElem;
    }
    
}