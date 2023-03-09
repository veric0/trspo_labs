package borakdmytro.util;

import java.util.Random;
import java.util.stream.IntStream;


public class ArrayGenerator {
    /**
     * @param length of array
     * @return generated array with random numbers
     */
    public static int[] generateRandomArray(int length) {
        Random rand = new Random();
        return IntStream.generate(rand::nextInt)
                .limit(length)
                .toArray();
    }

}
