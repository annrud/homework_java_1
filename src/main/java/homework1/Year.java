package homework1;

import java.util.Scanner;


public class Year {
    public static void main(String[] args) {
        System.out.print(isLeap());
    }
    public static boolean isLeap() {
        Scanner in = new Scanner(System.in);
        System.out.println("Программа определяет является ли год високосным.");
        System.out.print("Введите год: ");
        int year = in.nextInt();
        in.close();
        if (year % 4 == 0) {
            return (year % 100 != 0) | (year % 400 == 0);
        }
        return false;
    }
}
