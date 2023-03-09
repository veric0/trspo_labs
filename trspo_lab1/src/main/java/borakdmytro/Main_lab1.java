package borakdmytro;

import borakdmytro.sort.MergeSort;
import borakdmytro.sort.MergeSortParallel;
import borakdmytro.sort.Sort;
import borakdmytro.util.ArrayFileIO;
import borakdmytro.util.ArrayGenerator;
import borakdmytro.util.SortTimer;

import java.util.Arrays;
import java.util.Scanner;

public class Main_lab1 {
    public static void main(String[] args) {
        int[] arr = {};
        boolean loop = true;

        while (loop) {
            printMenu();
            switch (readNumberFromConsole()) {
                case 1 -> arr = generateNewArrayData();
                case 2 -> selectSortMethod(arr);
                case 3 -> saveResultToFile(arr);
                case 4 -> arr = getArrayFromFile();
                case 5 -> printArray(arr);
                case 6 -> loop = false;
                default -> rangeErrorMessage(1, 6);
            }
        }
    }

    public static void printMenu() {
        enterTheData("\n" +
                " Оберіть дію (1-6)\n" +
                " (1) - Сформувати масив випадкових чисел\n" +
                " (2) - Сортувати\n" +
                " (3) - Зберегти дані у файл\n" +
                " (4) - Зчитати вхідні дані з файлу\n" +
                " (5) - Вивести масив на екран\n" +
                " (6) - Вихід");
    }

    public static int readNumberFromConsole() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\n Введіть число");
                System.out.print(">>> ");
            }
        }
    }

    public static String readStringFromConsole() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return String.valueOf(input);
    }

    public static int[] generateNewArrayData() {
        enterTheData("\n Введіть довжину масиву ");
        int length = readNumberFromConsole();
        int[] arr = ArrayGenerator.generateRandomArray(length);
        printArray(arr);
        return arr;
    }

    public static void selectSortMethod(int[] arr) {
        Sort sort = null;
        while (sort == null) {
            enterTheData("\n" +
                    " Виберіть метод сорутвання\n" +
                    " (1) - MergeSort\n" +
                    " (2) - MergeSortParallel\n" +
                    " (0) - Скасувати ");
            switch (readNumberFromConsole()) {
                case 0 -> { return; }
                case 1 -> sort = new MergeSort();
                case 2 -> sort = new MergeSortParallel();
                default -> rangeErrorMessage(0, 2);
            }
        }
        double duration = SortTimer.measureTime(arr, sort);
        System.out.println("\n Час виконання: " + duration + " мс");
        printArray(arr);
    }

    public static void saveResultToFile(int[] arr) {
        enterTheData("\n Введіть назву текстового файлу");
        ArrayFileIO.writeArrayToFile(arr, readStringFromConsole());
    }

    public static int[] getArrayFromFile() {
        enterTheData("\n Введіть назву текстового файлу");
        int[] arr = ArrayFileIO.readArrayFromFile(readStringFromConsole());
        printArray(arr);
        return arr;
    }

    private static void enterTheData(String message) {
        System.out.println(message);
        System.out.print(">>> ");
    }

    public static void printArray(int[] arr) {
        System.out.println("\n Масив: " + Arrays.toString(arr));
    }

    public static void rangeErrorMessage(int start, int end) {
        System.out.printf("\n Введіть число в допустимих межах %d - %d \n", start, end);
    }
}