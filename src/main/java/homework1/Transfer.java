package homework1;

import java.util.Arrays;
import java.util.Random;

public class Transfer {
    public static void main(String[] args) {
        transferNumberToTheEnd();
    }
    public static void transferNumberToTheEnd() {
        byte val = 3;
        Random random = new Random();
        byte[] arr = new byte[20];
        for (byte i = 0; i < arr.length; i++) {
            arr[i] = (byte)random.nextInt(val+1);
        }
        System.out.println(
                "Программа переносит число 3 в конец массива."
        );
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        byte left = 0, right = (byte)(arr.length - 1);
        while (left < right){
            if (arr[left] == val && arr[right] != val) {
                byte temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } else if (arr[left] != val) {
                left++;
            } else if (arr[right] == val) {
                right--;
            }
        }
        System.out.println("Преобразованный массив: " + Arrays.toString(arr));
    }
}
