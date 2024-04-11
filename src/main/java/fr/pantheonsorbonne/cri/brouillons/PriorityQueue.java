package fr.pantheonsorbonne.cri.brouillons;
import java.util.Iterator;

public class PriorityQueue implements Iterable<String>{
    private int flag;
    private int[] data;

    public void MyPriorityQueue() {
        this.data = new int[1];
        this.flag = 0;
    }

    private void ensureCapacity(int n) {
        if (n <= data.length) {
            return;
        } else {
            int[] tab2 = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                tab2[i] = data[i];
            }
            data = tab2;
        }
    }

    // ajoute un élément à la file d'attente en respectant l'ordre de priorité
    public void add(int value) {
        ensureCapacity(flag + 1);
        int i = flag;
        while (i > 0 && data[i - 1] > value) {
            data[i] = data[i - 1];
            i--;
        }
        data[i] = value;
        flag++;
    }

    // retire et renvoie l'élément avec la plus haute priorité
    public int poll() {
        if (flag == 0) {
            throw new RuntimeException("La file d'attente est vide");
        }
        int res = data[0];
        flag--;
        if (flag > 0) {
            data[0] = data[flag];
        }
        return res;
    }

    // renvoie l'élément avec la plus haute priorité sans le retirer
    public int peek() {
        if (flag == 0) {
            throw new RuntimeException("La file d'attente est vide");
        }
        return data[0];
    }

    // renvoie une chaîne de caractères représentant la file d'attente
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < flag; i++) {
            sb.append(data[i]);
            if (i != flag - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    @Override
    public Iterator<String> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    
}
