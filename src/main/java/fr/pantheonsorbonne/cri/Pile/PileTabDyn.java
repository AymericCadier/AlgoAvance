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
public class PileTabDyn<E> extends PileTabStat<E>{
    
    public PileTabDyn(int taille) {
        super(taille);
    }
    
    public boolean empiler(E elem){
        if(sp==t.length){
            E []t1 = (E[]) new Object[2*sp];
            for(int i=0; i<sp; i++){
                t1[i] = t[i];
            }
            t=t1;
        }
        return super.empiler(elem);
    }
    
}
