package lesson3;

import java.util.HashMap;
import java.util.HashSet;

public class ListsHomework {

    private static final String[] words = {"MySQL", "supports", "atomic", "Data",
    "Definition", "Language", "statements", "This", "feature", "is", "referred",
    "to", "as", "atomic", "DDL", "An", "atomic", "DDL", "statement", "combines",
    "the", "data", "dictionary", "updates", "storage", "engine", "operations",
    "and", "binary", "log", "writes", "associated", "with", "a", "DDL",
    "operation", "into", "a", "single", "atomic", "operation"};

    public static void main(String[] args) {
        System.out.println(findListOfWords(words));
    }

    // List of words in phrase without repetitions. Used HashSet to "increase" performance.
    private static HashSet<String> findListOfWords(String[] s) {
        HashSet<String> setOfWords = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            setOfWords.add(s[i]);
        }
        return setOfWords;
    }

    // Count how many times each word occurs.
    private static HashMap<String, Integer> mapOfWords(String[] s) {
        HashMap<String , Integer>
    }
}
