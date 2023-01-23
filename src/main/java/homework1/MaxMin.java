package homework1;

import java.util.Arrays;
import java.util.Random;

public class MaxMin {
    public static void main(String[] args) {
        findMaxMin();
    }
    public static void findMaxMin() {
        Random random = new Random();
        short[] arr = new short[10];
        for (short i = 0; i < arr.length; i++) {
            arr[i] = (short)random.nextInt(1000);
        }
        System.out.println(
                "Программа находит в массиве " +
                        "минимальный и максимальный элементы."
        );
        System.out.println(Arrays.toString(arr));
        short max = arr[0], min = arr[0];
        for (short j : arr) {
            max = (max < j)
                    ? j
                    : max;
            min = (min > j)
                    ? j
                    : min;
        }
        System.out.println("min=" + min + ", max=" + max);

    }
    }
