package fr.pantheonsorbonne.cri;

import java.util.Iterator;

public class ArraylistIterator implements Iterator<String> {

    String[] data;
    int cpt = 0;
    int nb;

    public ArraylistIterator(String[] data) {
        this.data = data;
        nb = 0;
    }

    @Override
    public String next() {
        return data[cpt++];
    }

    @Override
    public boolean hasNext() {
        if (cpt < data.length) {
            return data[cpt] != null;
        } else {
            return false;
        }
    }

}