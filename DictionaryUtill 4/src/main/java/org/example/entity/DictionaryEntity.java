package org.example.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс представляет сущность словарного слова с его переводами.
 */
public class DictionaryEntity {
    private String word;
    private List<String> translations;

    /**
     * Конструктор для создания объекта DictionaryEntity с указанным словом и списком переводов.
     * @param word слово для добавления в словарь
     * @param translations список переводов для данного слова
     */
    public DictionaryEntity(String word, List<String> translations) {
        this.word = word;
        this.translations = new ArrayList<>(translations);
    }

    /**
     * Метод для добавления нового перевода к данному слову.
     * @param translation новый перевод для добавления
     */
    public void addTranslation(String translation) {
        translations.add(translation);
    }

    /**
     * Метод для получения слова из объекта DictionaryEntity.
     * @return слово из словаря
     */
    public String getWord() {
        return word;
    }

    /**
     * Метод для получения списка переводов данного слова.
     * @return список переводов для данного слова
     */
    public List<String> getTranslations() {
        return translations;
    }
}
