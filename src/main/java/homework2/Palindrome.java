package homework2;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа принимает на вход строку и " +
                "определяет является ли строка палиндромом.");
        System.out.print("Введите строку: ");
        String str = in.nextLine().toLowerCase().replace(" ", "");
        in.close();
        System.out.print(isPalindrome(str));
    }

    public static boolean isPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
