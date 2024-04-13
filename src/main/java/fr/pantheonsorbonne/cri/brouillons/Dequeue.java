package fr.pantheonsorbonne.cri.brouillons;
import java.util.Iterator;
public class Dequeue implements Iterable<String>{
    private int flag;
    private String[] data;

    public Dequeue() {
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

    // retire et renvoie l'élément en tête de la double file
    public String removeFirst() {
        if (flag == 0) {
            return "non";
        }
        String res = data[0];
        for (int i = 1; i < flag; i++) {
            data[i - 1] = data[i];
        }
        flag--;
        return res;
    }

    // retire et renvoie l'élément à la fin de la double file
    public String removeLast(){
        if (flag == 0) {
            return "non";
        }
        return data[--flag];
    }

    // ajoute un élément à la fin de la double file
    public void addLast(String s) {
        ensureCapacity(flag + 1);
        data[flag] = s;
        flag++;
    }

    // ajoute un élément au début de la double file
    public void addFirst(String s) {
        ensureCapacity(flag + 1);
        for (int i = flag; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = s;
        flag++;
    }

    // renvoie l'élément en tête de la double file sans le retirer
    public String peekFirst(){
        if (flag == 0) {
            return "non";
        }
        return data[0];
    }

    // renvoie l'élément à la fin de la double file sans le retirer
    public String peekLast(){
        if (flag == 0) {
            return "non";
        }
        return data[flag - 1];
    }

    // renvoie une chaîne de caractères représentant la double file
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
