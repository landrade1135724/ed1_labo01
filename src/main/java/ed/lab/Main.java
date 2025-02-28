package ed.lab;

import java.util.Random;

public class Main {

    // Generador que retorna un arreglo de String ordenado ascendentemente
    private static final ArrayGenerator<String> sortedArrayGenerator = (int length) -> {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = String.valueOf((char) ('A' + i)); // Genera letras de la A a la Z
        }
        return array;
    };

    // Generador que retorna un arreglo de String ordenado descendentemente
    private static final ArrayGenerator<String> invertedArrayGenerator = (int length) -> {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = String.valueOf((char) ('Z' - i)); // Genera letras de la Z a la A
        }
        return array;
    };

    // Generador que retorna un arreglo de String con valores aleatorios
    private static final ArrayGenerator<String> randomArrayGenerator = (int length) -> {
        String[] array = new String[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = String.valueOf((char) ('A' + random.nextInt(26))); // Genera letras aleatorias
        }
        return array;
    };

    private static final QuickSort<String> highPivotQuickSort = array -> SortingAlgorithms.highPivotQuickSort(array);
    private static final QuickSort<String> lowPivotQuickSort = array -> SortingAlgorithms.lowPivotQuickSort(array);
    private static final QuickSort<String> randomPivotQuickSort = array -> SortingAlgorithms.randomPivotQuickSort(array);

    public static QuickSort<String> getHighPivotQuickSort() {
        return highPivotQuickSort;
    }

    public static QuickSort<String> getLowPivotQuickSort() {
        return lowPivotQuickSort;
    }

    public static QuickSort<String> getRandomPivotQuickSort() {
        return randomPivotQuickSort;
    }

    public static ArrayGenerator<String> getSortedArrayGenerator() {
        return sortedArrayGenerator;
    }

    public static ArrayGenerator<String> getInvertedArrayGenerator() {
        return invertedArrayGenerator;
    }

    public static ArrayGenerator<String> getRandomArrayGenerator() {
        return randomArrayGenerator;
    }

    public static void main(String[] args) {
        final SortingTester<String> tester = new SortingTester<>();

        System.out.println("Ordenando un arreglo ordenado:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(sortedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo invertido:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(invertedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");
    }
}
