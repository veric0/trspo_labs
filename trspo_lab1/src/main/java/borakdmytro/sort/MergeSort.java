package borakdmytro.sort;

public class MergeSort implements Sort {
    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    @Override
    public void sort(int[] arr, int left, int right) {
        mergeSort(arr, left, right);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    protected static void merge(int[] arr, int left, int mid, int right) {
        int length1 = mid - left + 1;
        int length2 = right - mid;
        int[] leftArr = new int[length1];
        int[] rightArr = new int[length2];

        for (int i = 0; i < length1; ++i) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < length2; ++j) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < length1 && j < length2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < length1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < length2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

}

