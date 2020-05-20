package lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class ListsHomework {

    private static final class Person {
        private String surName;
        private String name;
        private String middleName;

        Person(String surName, String name, String middleName) {
            this.surName = surName;
            this.name = name;
            this.middleName = middleName;
        }

        public String getSurname(String surName) {
            return surName;
        }
    }

    private static final class PhoneBook {
        
    }

    private static final String[] words = {"MySQL", "MySQL", "supports", "atomic", "Data",
            "Definition", "Language", "statements", "This", "feature", "is", "supports",
            "feature", "MySQL", "Language", "This", "Definition", "atomic", "statements",
            "atomic", "Language", "MySQL", "This", "feature", "is", "Definition", "atomic",
            "feature", "This", "supports", "MySQL"};

    public static void main(String[] args) {
        System.out.println(findListOfWords(words));
        System.out.println(mapOfRepeatedWords(words));
    }

    // List of words in phrase without repetitions.
    private static ArrayList<String> findListOfWords(String[] s) {

        ArrayList<String> listOfWords = new ArrayList<>();
        listOfWords.add(s[0]);
        for (int i = 1; i < s.length; i++) {
            boolean mismatchCondition = !s[i].equals(s[0]);
            for (int j = 0; j < i && mismatchCondition; j++) {
                mismatchCondition = !s[i].equals(s[j]);
            }
            if (mismatchCondition)
                listOfWords.add(s[i]);
        }
        return listOfWords;
    }

    // Count how many times each word occurs.
    private static HashMap<String, Integer> mapOfRepeatedWords(String[] s) {

        HashMap<String, Integer> mapOfWords = new HashMap<>();

        for (int i = 0; i < findListOfWords(s).size(); i++) {
            int k = 0;
            for (int j = 0; j < s.length; j++) {
                if (findListOfWords(s).get(i).equals(s[j]))
                    k++;
                else continue;
            }
            mapOfWords.put(findListOfWords(s).get(i), k);
        }
        return mapOfWords;
    }
}
