package borakdmytro.sort;

public class MergeSortParallel extends MergeSort {
    /**
     * approximately the optimal number of threads
     */
    private static final int MAX_THREADS = 8;
    private static int activeThreads = 0;

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
            if (activeThreads < MAX_THREADS) {
                activeThreads += 2;
                Thread leftThread = new Thread(() -> mergeSortParallel(arr, left, mid));
                Thread rightThread = new Thread(() -> mergeSortParallel(arr, mid + 1, right));
                leftThread.start();
                rightThread.start();
                try {
                    leftThread.join();
                    rightThread.join();
                    activeThreads -= 2;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                mergeSort(arr, left, mid);
                mergeSort(arr, mid + 1, right);
            }
            merge(arr, left, mid, right);
        }
    }

}

