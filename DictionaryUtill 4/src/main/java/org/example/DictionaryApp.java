package org.example;

import org.example.service.DictionaryService;

import java.util.Scanner;

/**
 * Класс для запуска приложения словаря.
 */
public class DictionaryApp {

    public static void main(String[] args) {
        DictionaryService service = new DictionaryService();//создание объекта DictionaryService
        Scanner scanner = new Scanner(System.in);
        service.printDictionary();

        // вывод действия
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить новое слово и перевод");
            System.out.println("2. Удалить слово из словаря");
            System.out.println("3. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем лишний перевод строки

            switch (choice) {
                case 1:
                    service.addWordTranslation(scanner);
                    break;
                case 2:
                    service.removeWord(scanner);
                    break;
                case 3:
                    System.out.println("Словарь:");
                    service.printDictionary();
                    System.exit(0);
                default:
                    System.out.println("Некорректный ввод. Повторите попытку.");
            }
        }
    }
}
