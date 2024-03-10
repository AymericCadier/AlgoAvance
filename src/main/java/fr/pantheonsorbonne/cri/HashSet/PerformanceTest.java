package fr.pantheonsorbonne.cri.HashSet;

import java.util.Random;

public class PerformanceTest {

    public static void main(String[] args) {
        // Création d'une instance de la classe StringHashSet
        StringHashSet list = new StringHashSet();

        // Tailles de données à tester
        int[] sizes = { 100, 1000, 5000, 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000,
                55000, 60000, 65000, 70000, 75000, 80000, 85000, 90000, 95000, 100000 };

        // Mesure et affichage des temps d'exécution pour chaque taille de données
        for (int size : sizes) {

            long duration = 0;

            // Ajout d'éléments à la liste
            for (long i = 0; i < size; i++) {
                int j = new Random().nextInt(0, size);
                long startTime = System.nanoTime();
                list.add("Element" + j);
                long endTime = System.nanoTime();
                duration += (endTime - startTime);
            }

            // Moyenne du temps d'exécution
            duration /= size;

            System.out.println("Temps d'exécution pour " + size + " éléments : " + duration + " nanosecondes");
        }
    }
}
