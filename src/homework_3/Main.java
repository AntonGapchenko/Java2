package homework_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] arrayWords = {"BMW", "TOYOTA", "LADA", "SKODA", "LADA", "FORD", "VOLKSWAGEN", "KIA", "HONDA", "KIA"};
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(arrayWords));
        System.out.println("Изначальный массив:" + Arrays.toString(arrayWords));
        System.out.println("Уникальные слова:" + uniqueWords);
        for (String word : uniqueWords) {
            System.out.print(word + "-" + Collections.frequency(Arrays.asList(arrayWords), word) + " ");
        }


        //Задание№2____________________________________________
        System.out.println();
        System.out.println("__________________________________________________________________________________________");
        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", "+79867776434");
        phonebook.add("Петров", "+7986723421");
        phonebook.add("Сидоров", "+79867709450");
        phonebook.add("Смирнов", "+79862376401");
        phonebook.add("Иванов", "+79518764523");
        phonebook.add("Сидоров", "+79867709450");
        phonebook.get("Петров");
        phonebook.get("Иванов");
        phonebook.get("Пупкин");


    }
}
