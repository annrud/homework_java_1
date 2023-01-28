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
        String str = in.nextLine();
        in.close();
        StringBuilder strBuild = new StringBuilder();
        for (int i = str.length()-1; i > -1; i--) {
            strBuild.append(str.charAt(i));
        }
        return strBuild.toString().equals(str);
    }
}
