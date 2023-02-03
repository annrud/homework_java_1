package homework3;

import java.util.ArrayList;
import java.util.HashMap;
import static homework3.RemovingEven.*;

public class MaxMinAverage {
    public static void main(String[] args) {
        System.out.println("Прогрпмма находит минимальное, максимальное и среднее арифметическое списка.");
        int lengthOfList = userInput("Введите количество элементов списка: ");
        int maxValueOfList = userInput("Программа рандомно заполнит ваш спикок " +
                "элементами до указанного значения. Ведите это значение: ");
        ArrayList<Integer> listOfInt = getList(lengthOfList, maxValueOfList);
        System.out.println(listOfInt);
        System.out.println("min=" + findMinMax(listOfInt).get("min"));
        System.out.println("max=" + findMinMax(listOfInt).get("max"));
        System.out.println("average=" + getAverageValue(listOfInt));
    }

    public static HashMap<String, Integer> findMinMax(ArrayList<Integer> lst) {
        HashMap<String, Integer> results = new HashMap<>();
        int min = lst.get(0);
        int max = lst.get(0);
        for (int i = 1; i < lst.size(); i++) {
            if (max < lst.get(i)) {
                max = lst.get(i);
            } else {
                if (min > lst.get(i)) {
                    min = lst.get(i);
                }
            }
        }
        results.put("min", min);
        results.put("max", max);
        return results;
    }

    public static double getAverageValue(ArrayList<Integer> lst){
        int sum = 0;
        for (int value: lst) {
            sum += value;
        }
        return (double) sum/lst.size();
    }
}
