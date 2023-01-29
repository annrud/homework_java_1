package homework2;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.print(isPalindrome());
    }
    public static boolean isPalindrome() {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа принимает на вход строку и " +
                "определяет является ли строка палиндромом.");
        System.out.print("Введите строку: ");
        String str = in.nextLine().toLowerCase().replace(" ", "");
        in.close();
        System.out.println(str);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
