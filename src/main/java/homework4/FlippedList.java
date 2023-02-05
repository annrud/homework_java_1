package homework4;

import java.util.LinkedList;
import java.util.Scanner;

public class FlippedList {
    public static void main(String[] args) {
        System.out.println("Программа переворачивает список.");
        LinkedList<Integer> userList =  userInput();
        System.out.println("Исходный список: " + userList);
        LinkedList<Integer> userFlipList = flipList(userList);
        System.out.println("Перевёрнутый список: " + userFlipList);
    }

    public static LinkedList<Integer> userInput() {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> linkedList = new LinkedList<>();
        while(true) {
            System.out.println("Введите целые числа через пробел : ");
            String[] input = scan.nextLine().split(" ");

            try {
                for (String i : input) {
                    linkedList.add(Integer.parseInt(i));
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Неправильный формат ввода чисел!");
            }
        }
        return linkedList;
    }

    public static LinkedList<Integer> flipList(LinkedList<Integer> linkedList) {
        for (int i = 0; i < linkedList.size() / 2; i++) {
            int temp = linkedList.get(i);
            linkedList.set(i, linkedList.get(linkedList.size() - i - 1));
            linkedList.set(linkedList.size() - i - 1, temp);
        }
        return linkedList;
    }
}
