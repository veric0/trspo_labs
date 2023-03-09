package borakdmytro.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayFileIO {
    /**
     * @param fileName name of file with numbers separated with ", "
     * @return array filled with numbers from file
     */
    public static int[] readArrayFromFile(String fileName) {
        fileName = fileName + ".txt";
        int[] array;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String[] values = reader.readLine().split(", ");
            int length = values.length;
            array = new int[length];
            IntStream.range(0, length)
                    .forEach(i -> array[i] = Integer.parseInt(values[i]));
            System.out.println("\n Результат було зчитано з файлу " + fileName);
        } catch (IOException e) {
            System.out.println("\n Сталася помилка під час читання файлу " + fileName + "\n");
            return new int[0];
        }
        return array;
    }

    /**
     * @param arr array to be written to file
     * @param fileName name of file to write to
     */
    public static void writeArrayToFile(int[] arr, String fileName) {
        fileName = fileName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName))) {
            writer.write(Arrays.toString(arr).replace("[", "").replace("]", ""));
            System.out.println("\n Результат було збережено y файл " + fileName);
        } catch (IOException e) {
            System.out.println("\n Сталася помилка під час збереження файлу " + fileName + "\n");
        }
    }
}
