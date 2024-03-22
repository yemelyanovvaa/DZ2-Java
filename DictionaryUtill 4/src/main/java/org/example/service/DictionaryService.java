package org.example.service;

import org.example.entity.DictionaryEntity;

import java.util.*;

public class DictionaryService {

    private final Map<String, DictionaryEntity> dictionary = new HashMap<>();
    private List<String> wordList = new ArrayList<>();

    public DictionaryService() {
        // Инициализация словаря при создании объекта службы
        initializeDictionary();
    }

    private void initializeDictionary() {
        // Начальное заполнение словаря
        dictionary.put("Abdication", new DictionaryEntity("Abdication", Arrays.asList("отречение", "отказ", "сложение полномочий")));
        dictionary.put("Aperitif", new DictionaryEntity("Aperitif", Collections.singletonList("аперитив")));
        dictionary.put("Mead", new DictionaryEntity("Mead", Arrays.asList("мёд", "луг")));
        dictionary.put("Zizz", new DictionaryEntity("Zizz", Collections.singletonList("жужжание")));

        updateWordList();
    }

    private void updateWordList() {
        // Обновление списка слов
        wordList.clear();
        wordList.addAll(dictionary.keySet());
    }

    public void addWordTranslation(Scanner scanner) {
        // Метод для добавления нового слова и его перевода в словарь
        System.out.print("Введите слово (английское): ");
        String word = scanner.nextLine();

        System.out.print("Введите перевод(ы) через запятую: ");
        String translationsInput = scanner.nextLine();

        List<String> translations = Arrays.asList(translationsInput.split(", "));

        dictionary.computeIfPresent(word, (existingWord, entity) -> {
            // Если слово уже существует, добавляем новые переводы
            translations.forEach(entity::addTranslation);
            return entity;
        });

        if (!dictionary.containsKey(word)) {
            // Если слово новое, добавляем его с переводами
            DictionaryEntity newEntity = new DictionaryEntity(word, translations);
            dictionary.put(word, newEntity);
            wordList.add(word);
        }

        printDictionary();
    }

    public void removeWord(Scanner scanner) {
        // Метод для удаления слова из словаря
        System.out.print("Введите слово (английское), которое нужно удалить: ");
        String wordToRemove = scanner.nextLine();

        dictionary.remove(wordToRemove);
        wordList.remove(wordToRemove);

        printDictionary();
    }

    public void printDictionary() {
        // Метод для вывода содержимого словаря
        dictionary.values().stream()
                .sorted(Comparator.comparing(DictionaryEntity::getWord))
                .forEach(entity -> System.out.println(entity.getWord() + " — " + String.join("; ", entity.getTranslations())));

        System.out.println("\nТекущий список слов в словаре:");
        System.out.println(wordList);
    }
}
