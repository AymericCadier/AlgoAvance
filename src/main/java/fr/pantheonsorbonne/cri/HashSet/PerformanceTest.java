package fr.pantheonsorbonne.cri.HashSet;

public class PerformanceTest {

    public static void main(String[] args) {
        StringHashSet set = new StringHashSet();
        final int numberOfElements = 1000; // Ajustez pour différents volumes

        // Testing add operation
        // long startTime = System.nanoTime();
        // for (int i = 0; i < numberOfElements; i++) {
        //     set.add("Element " + i);
        // }
        // long endTime = System.nanoTime();
        // long durationAdd = endTime - startTime;
        // System.out.println("Temps pris pour ajouter " + numberOfElements + " éléments: " + durationAdd + " ns");

        // Testing contains operation
        for (long i=0; i<100000; i++) {
            set.add("salut" + i);
        }
        long totalDurationContains = 0;
        
        for (int i = 0; i < 100000; i++) {   
            long startTime = System.nanoTime();
            for (long j = 0; j < 100000; j++) {
                set.contains("salut" + j);
            }
           long endTime = System.nanoTime();
            totalDurationContains += (endTime - startTime)/1000;
        }
        double averageDurationContains = (double) totalDurationContains / 1000.0;
        System.out.println("Temps pris pour vérifier un élément existant (moyenne sur 1000 exécutions): " + averageDurationContains + " microsecondes");

        // Testing remove operation
        // long totalDurationRemove = 0;
        // for (int i = 0; i < 1000; i++) {
        //     startTime = System.nanoTime();
        //     set.remove("Element 5000"); // Suppression de l'élément 5000 à titre d'exemple
        //     endTime = System.nanoTime();
        //     totalDurationRemove += (endTime - startTime);
        // }
        // double averageDurationRemove = (double) totalDurationRemove / 1000.0;
        // System.out.println("Temps pris pour supprimer un élément (moyenne sur 1000 exécutions): " + averageDurationRemove + " ns");
    }
}
