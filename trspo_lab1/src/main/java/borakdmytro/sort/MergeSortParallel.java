package borakdmytro.sort;

public class MergeSortParallel extends MergeSort {
    @Override
    public void sort(int[] arr) {
        mergeSortParallel(arr, 0, arr.length - 1);
    }

    @Override
    public void sort(int[] arr, int left, int right) {
        mergeSortParallel(arr, left, right);
    }

    private static void mergeSortParallel(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            Thread leftThread = new Thread(() -> mergeSortParallel(arr, left, mid));
            Thread rightThread = new Thread(() -> mergeSortParallel(arr, mid + 1, right));
            leftThread.start();
            rightThread.start();
            try {
                leftThread.join();
                rightThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            merge(arr, left, mid, right);
        }
    }

//    public static void main(String[] args) {
//        int[] arr = {4, 7, 2, 8, 3, 5};
//        mergeSortParallel(arr);
//        System.out.println(Arrays.toString(arr)); // output: [2, 3, 4, 5, 7, 8]
//    }
}

