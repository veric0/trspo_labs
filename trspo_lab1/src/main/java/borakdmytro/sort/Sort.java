package borakdmytro.sort;

public interface Sort {
    /**
     * Sort full array
     * @param arr array to be sorted
     */
    void sort(int[] arr);

    /**
     * Sort part of the array
     * @param arr array to be sorted
     * @param left start index inclusive
     * @param right end index inclusive
     */
    void sort(int[] arr, int left, int right);
}
