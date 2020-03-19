package ua.com.foxminded.task4.logic;

import java.util.LinkedHashMap;
import java.util.Map;

public class CounterCharacters {

    public String getCountedCharacters(String sentence) {
        Map<Character, Integer> cachedValues = new LinkedHashMap();
        // add to map
        for (int i = 0; i < sentence.length(); i++) {
            cachedValues.put(sentence.charAt(i), 0);
        }
        // adjust value if in sentence occur the same letter
        for (int i = 0; i < sentence.length(); i++) {
            for (Map.Entry<Character, Integer> entry : cachedValues.entrySet()) {
                if (entry.getKey() == sentence.charAt(i)) {
                    int quantityLetters = entry.getValue();
                    cachedValues.replace(entry.getKey(), ++quantityLetters);
                }
            }
        }
        return wrapperInString(cachedValues);
    }

    private String wrapperInString(Map<Character, Integer> map) {
        StringBuilder mapAsString = new StringBuilder("");
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            mapAsString.append("'").append(entry.getKey()).append("'").append(" - ").append(entry.getValue()).append("\n");
        }
        return mapAsString.toString().trim();
    }
}
