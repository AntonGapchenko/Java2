package homework_3;


import java.util.HashMap;
import java.util.HashSet;


public class Phonebook {
    private HashMap<String, HashSet<String>> phoneBook;

    public Phonebook() {
        phoneBook = new HashMap<>();
    }

    public boolean add(String surname, String number) {
        HashSet<String> phoneNumbers = phoneBook.getOrDefault(surname, new HashSet<>());
        if (phoneNumbers.add(number)) {
            phoneBook.put(surname, phoneNumbers);
            System.out.println(surname + " добавлен в книгу. Номер:" + number);
            return true;
        } else {
            System.out.println(surname + " c таким номером уже добавлен");
            return false;
        }
    }

    public void get(String surname) {
        if (phoneBook.containsKey(surname)) {
            System.out.println(surname + "-" + phoneBook.get(surname));
        } else {
            System.out.println("Абонент " + surname + " в справочнике не найден");
        }

    }
}
