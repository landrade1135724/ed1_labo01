package ed.lab;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingTester<T extends Comparable<T>> {
    private static final int ARRAY_SIZE = 1000;
    private static final int TEST_SIZE = 100;

    public void testSorting(ArrayGenerator<T> generator, QuickSort<T> quickSort) {
        T[] array = generator.generate(ARRAY_SIZE);

        List<Long> durations = new ArrayList<>(TEST_SIZE);

        for (int i = 0; i < TEST_SIZE; i++) {
            T[] copy = Arrays.copyOf(array, array.length);

            // Usando System.nanoTime() para medición de tiempo
            final long startTime = System.nanoTime();

            quickSort.sort(copy);

            final long endTime = System.nanoTime();
            durations.add(endTime - startTime); // Guardamos la duración en nanosegundos
        }

        // Cálculo del promedio en milisegundos
        double average = durations.stream()
                .mapToLong(duration -> duration) // No es necesario convertir a nanoTime en este punto
                .average()
                .orElse(0);

        // Cálculo de la sumatoria total en milisegundos
        long total = durations.stream()
                .mapToLong(duration -> duration)
                .sum();

        System.out.printf("\t\tTiempo promedio: %.2f ms\n", average / 1_000_000.0);  // Convertimos a milisegundos
        System.out.printf("\t\tTiempo total: %d ms\n", total / 1_000_000);  // Convertimos a milisegundos
    }

}
