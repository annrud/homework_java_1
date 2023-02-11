package homework6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Laptop dexpAquilon = new Laptop("Aquilon", 14f,  "silver",
                "plastic", "Intel Celeron N4020",
                4, 128, "DEXP", 15999);

        Laptop irbisNB270 = new Laptop("NB270", 14.1f,  "white",
                "plastic", "Intel Celeron N4020",
                4, 128, "Irbis", 15999);

        Laptop envyEchips = new Laptop("Echips", 14f,  "silver",
                "plastic", "Intel Celeron J4125",
                8, 240, "Envy", 21999);

        Laptop hp255G8= new Laptop("255 G8", 15.6f,  "silver",
                "plastic", "AMD Athlon Gold 3150U",
                4, 1000, "HP", 22999);

        Laptop acerExtensa = new Laptop("Extensa 15 EX215-31-C3FF", 15.6f,  "black",
                "plastic", "Intel Celeron N4020",
                4, 128, "Acer", 25999);

        Laptop lenovoIdeaPad = new Laptop("IdeaPad 3 15IGL05", 15.6f,  "silver",
                "plastic", "Intel Celeron N4020",
                4, 1000, "Lenovo", 25999);

        Laptop msiModern = new Laptop("Modern 14 C12M-229RU", 15.6f,  "black",
                "plastic", "Intel Core i5-1235U",
                16, 512, "MSI", 50999);

        Laptop asusVivoBook = new Laptop("VivoBook 14 K413EP-EB347", 14f,  "black",
                "plastic", "Intel Core i5-1135G7",
                8, 256, "ASUS", 51999);

        Laptop gigabyteU4UD = new Laptop("U4 UD", 14f,  "silver",
                "aluminum", "Intel Core i5-1155G7",
                16, 512, "GIGABYTE", 57999);

        ArrayList<Laptop> laptops = new ArrayList<>(Arrays.asList(dexpAquilon, irbisNB270, envyEchips,
                hp255G8, acerExtensa, lenovoIdeaPad, msiModern,
                asusVivoBook, gigabyteU4UD));
        System.out.println("Программа поможет вам выбрать ноутбук. Для прерывания введите \"exit\".");
        int cash = userInput("Введите сумму, которой располагаете для покупки ноутбука: ");
        int ram = userInput("Введите минимальный размер опративной памяти (4, 8, 16): ");
        ArrayList<Laptop> possibleOptions= chooseLaptop(cash, ram, laptops);
        if (possibleOptions.size() == 0){
            System.out.println("По вашему запросу, к сожалению, нет подходящих вариантов.");
        } else {
            System.out.println("Вам подойдут следующие варианты:");
            for (Laptop laptop: possibleOptions) {
                System.out.println(laptop);
            }
        }


    }
    public static int userInput(String str){
        int inputCash;
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println(str);
            String input = scan.nextLine();
            try {
                if (input.equals("exit")) {
                    System.exit(0);
                }
                inputCash = Integer.parseInt(input);
                return inputCash;
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число!");
            }
        }
    }


    public static ArrayList<Laptop> chooseLaptop(
            int userCash,
            int ramUser,
            ArrayList<Laptop> laptopsPossible
    ) {
        ArrayList<Laptop> userLaptops = new ArrayList<>();
        for (Laptop laptop: laptopsPossible) {
            if (laptop.getPrice() <= userCash && laptop.getRAM() >= ramUser) {
                userLaptops.add(laptop);
            }
        }
        return userLaptops;
    }
}
