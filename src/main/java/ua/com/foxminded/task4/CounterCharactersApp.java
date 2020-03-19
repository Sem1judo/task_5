package ua.com.foxminded.task4;

import ua.com.foxminded.task4.logic.CounterCharacters;

public class CounterCharactersApp {

    public static void main(String[] args) {
        String sentence = "hello world!";
        CounterCharacters counter = new CounterCharacters();
        System.out.println(counter.getCountedCharacters(sentence));

    }
}
