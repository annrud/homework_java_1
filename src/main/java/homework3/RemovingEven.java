package homework3;

import java.util.*;

public class RemovingEven {
    private static final Random RANDOM = new Random();

    public static void main(String[] args){
        System.out.println("Программа удаляет из списка целых чисел четные числа.");
        int lengthOfList = userInput("Введите количество элементов списка: ");
        int maxValueOfList = userInput("Программа рандомно заполнит ваш спикок " +
                "элементами до указанного значения. Ведите это значение: ");
        ArrayList<Integer> listOfInt = getList(lengthOfList, maxValueOfList);
        System.out.println("Исходный список: " + listOfInt);
        System.out.println("Список из нечётных чисел: " + removeItem(listOfInt));
    }
    public static int userInput(String msg) {
        Scanner sc = new Scanner(System.in);
        int inputStr;
        while (true) {
            System.out.print(msg);
            try {
                inputStr = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод! Введите целое цисло!");
            }
        }
        return inputStr;
    }

    public static ArrayList<Integer> getList(int length, int maxValue){
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            lst.add(RANDOM.nextInt(maxValue+1));
        }
        return lst;
    }

    public static ArrayList<Integer> removeItem(ArrayList<Integer> lst){
        lst.removeIf(number -> number % 2 == 0);
        return lst;
    }
}
