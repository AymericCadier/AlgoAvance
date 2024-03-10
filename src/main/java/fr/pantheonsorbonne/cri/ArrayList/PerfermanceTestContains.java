package fr.pantheonsorbonne.cri.ArrayList;

import java.util.Random;

public class PerfermanceTestContains {
    public static void main(String[] args) {

        int[] iterations = { 100, 1000, 5000, 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000,
                55000, 60000, 65000, 70000, 75000, 80000, 85000, 90000, 95000, 100000 };

        for (int iter : iterations) {
            // Création d'une nouvelle instance de la classe StringArrayList
            ArrayList list = new ArrayList();

            // Ajout de des éléments à la liste
            for (int i = 0; i < iter; i++) {
                list.add("Element " + i);
            }

            // Mesure du temps d'exécution moyen de la méthode contains
            long totalDuration = 0;
            for (int i = 0; i < iter; i++) {
                int j = new Random().nextInt(0, iter);
                long startTime = System.nanoTime();
                list.contains("Element " + j); // Ajuster l'élément que l'on recherche
                long endTime = System.nanoTime();
                totalDuration += (endTime - startTime) / 1000; // Durée en microsecondes
            }

            long averageDuration = totalDuration / iter;

            // Affichage du temps d'exécution moyen
            System.out.println("Pour " + iter + " itérations, temps d'exécution moyen de la méthode : "
                    + averageDuration + " microsecondes");
        }
    }
}
