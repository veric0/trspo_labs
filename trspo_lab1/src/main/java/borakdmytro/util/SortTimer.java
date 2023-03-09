package borakdmytro.util;

import borakdmytro.sort.Sort;

public class SortTimer {
    /**
     * sorts the array and detects the duration of the sorting
     * @param arr array to be sorted
     * @param sortingClass the class that will sort
     * @return sort duration in milliseconds
     */
    public static double measureTime(int[] arr, Sort sortingClass) {
        long startTime = System.nanoTime();
        sortingClass.sort(arr);
        long endTime = System.nanoTime();
        return (double) (endTime - startTime) / 1_000_000;
    }
}
