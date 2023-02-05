package homework4;

import java.util.*;

public class ConsoleApp {
    public static void main(String[] args) {
        System.out.println("""
        Программа принимает строки и добавляет их в начало списка. 
        Если введено "print" - печатает список, 
        если введено "revert" - удаляет предыдущий ввод из списка, 
        для выхода из программы введите "exit".
        """ );
        changeTheList();
    }

    public static void changeTheList() {
        LinkedList<String> linkedList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Введите строку: ");
            String in = sc.nextLine();
            if (in.length() == 0) {
                System.out.println("Строка не должна быть пустой");
            } else if (in.equals("exit")) {
                break;
            } else if (in.equals("print")) {
                System.out.println(linkedList);
            } else if (in.equals("revert")) {
                if (linkedList.size() == 0) {
                    continue;
                } else {
                    try {
                        linkedList.removeFirst();
                        String last = linkedList.removeLast();
                        linkedList.addFirst(last);
                    } catch(NoSuchElementException ignored) {}
                }
            } else {
                try {
                    String first = linkedList.removeFirst();
                    linkedList.addLast(first);
                    linkedList.addFirst(in);
                } catch(NoSuchElementException e) {
                    linkedList.add(in);
                }
            }
        }
        sc.close();
    }
}


