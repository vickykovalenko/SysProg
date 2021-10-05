package com.company;
import java.util.Scanner; //  to read input in a Java
import java.io.File; //Java’s representation of a file or directory path name (if f.exists()...)
import java.io.FileNotFoundException;
import java.util.Arrays; //Array class in Java

public class Main {

    private final static String FILE_PATH = "input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String path = FILE_PATH;
        Analyzer analyzer = new Analyzer();
        System.out.println(Arrays.deepToString(analyzer.performTask(path))); //Arrays.deepToString() method of the Java language
        // returns a string
        // representation of a multidimensional array, providing the strings with square brackets:
    }
}
