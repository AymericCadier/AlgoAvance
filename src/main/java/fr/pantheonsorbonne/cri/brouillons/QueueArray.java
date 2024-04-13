package fr.pantheonsorbonne.cri.brouillons;

import java.util.Iterator;

public class QueueArray implements Iterable<String> {

    private int flag;
    private String[] data;

    public QueueArray() {
        this.data = new String[1];
        this.flag = 0;
    }

    private void ensureCapacity(int n) {
        if (n <= data.length) {
            return;
        } else {
            String[] tab2 = new String[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                tab2[i] = data[i];
            }
            data = tab2;
        }
    }

    // retire et renvoie l'élément en tête de la file d'attente
    public String remove() {
        if (flag == 0) {
            throw new IllegalStateException("La file d'attente est vide");
        }
        String res = data[0];
        for (int i = 1; i < flag; i++) {
            data[i - 1] = data[i];
        }
        flag--;
        return res;
    }

    // ajoute un élément à la fin de la file d'attente et retourne true si l'opération a réussi
    public boolean offer(String s) {
        ensureCapacity(flag + 1);
        data[flag] = s;
        flag++;
        return true;
    }

    // renvoie l'élément en tête de la file d'attente sans le retirer
    public String peek() {
        if (flag == 0) {
            throw new IllegalStateException("La file d'attente est vide");
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
        return new Iterator<String>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < flag;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new IllegalStateException("Plus d'éléments dans la file d'attente");
                }
                return data[currentIndex++];
            }
        };
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray();
        q.offer("a");
        q.offer("b");
        q.offer("c");
        System.out.println(q);
        System.out.println(q.remove());
        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q);

        for (String s : q) {
            System.out.println(s);
        }
    }
}
