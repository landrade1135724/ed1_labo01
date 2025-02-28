package ed.lab;

import java.util.Random;

public class SortingAlgorithms {

    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, "high");
    }

    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, "low");
    }

    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, "random");
    }

    // Implementación general de QuickSort con diferentes estrategias de pivote
    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, String pivotType) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, pivotType);
            quickSort(array, low, pivotIndex - 1, pivotType);
            quickSort(array, pivotIndex + 1, high, pivotType);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int low, int high, String pivotType) {
        int pivotIndex = switch (pivotType) {
            case "low" -> low;
            case "random" -> new Random().nextInt(high - low + 1) + low;
            default -> high;
        };

        T pivot = array[pivotIndex];
        swap(array, pivotIndex, high);  // Mover el pivote al final
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
