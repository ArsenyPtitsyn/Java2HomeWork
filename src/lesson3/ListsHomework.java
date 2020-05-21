package lesson3;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListsHomework {

    public static class Person {

        private String surName;
        private String name;
        private String middleName;
        private String PhoneNumber;
        private String mail;

        Person(String surName,
               String name,
               String middleName,
               String PhoneNumber,
               String mail) {
            this.surName = surName;
            this.name = name;
            this.middleName = middleName;
            this.PhoneNumber = PhoneNumber;
            this.mail = mail;
        }

        public String getSurname() {
            return surName;
        }
        public String getName() {
            return name;
        }
        public String getMiddleName() {
            return middleName;
        }
        public String getPhoneNumber() {
            return PhoneNumber;
        }
        public String getMail() {
            return mail;
        }
    }

    public static class PhoneBook {
        
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
