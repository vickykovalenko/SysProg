package com.company;

import java.io.*;
import java.lang.constant.Constable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.regex.*;
import java.util.List;

class Analyzer {
    boolean isLetter(char ch) {
        return Character.isLetter(ch);
    }

    boolean isWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!(isLetter(word.charAt(i)) || (word.charAt(i) == '\'' && i > 0 && isLetter(word.charAt(i - 1)) &&
                    i < word.length() - 1 && isLetter(word.charAt(i + 1))))) {
                return false;
            }
        }
        return word.length() > 0;
    }

    String[] splitter(String text) {
        String[] split = text.split("[^a-zA-Z']");
        String Text2[] = new String[split.length];
        for (int i = 0; i <= split.length - 1; i++) {
            if (split[i].length() <= 30) {
                Text2[i] = split[i];
            } else {
                Text2[i] = split[i].substring(0, 30);
            }
        }
        return new ArrayList<>(Arrays.asList(Text2))
                .stream()
                .distinct()
                .filter(this::isWord) //lambda expression, sort by word
                .toArray(String[]::new); //String[]::new means size -> new String[size].
    }

    String readFromFile(String path) throws FileNotFoundException { //bufferedReader - Reads text from a character-input stream,
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        return bufferedReader.lines().collect(Collectors.joining("\n"));
    }

    String[] StringWithOnlyVowels(String[] words) {
        Pattern pat = Pattern.compile("(?i)^[aeiou]+$"); //(?i) - case case-insensitive mode ON
        List<String> listOfVowels = new ArrayList<>();
        for (String s : words) {
            Matcher m = pat.matcher(s);
            if (m.find()) {
                listOfVowels.add(s);
            }
        }
        String[] strings = listOfVowels.toArray(new String[listOfVowels.size()]);
        return strings;
    }

    public String[] performTask(String path) throws FileNotFoundException {
        String text = readFromFile(path);//text as string
        String[] splitText = splitter(text);
        return StringWithOnlyVowels(splitText);
    }
}
