package it.sevenbits.homework;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *  class with parse method(for file)
 */
public class FileParser implements IParser {
    /**
     * separates the words in the file
     * @param delimiter specified delimiter
     * @param sourse file path
     * @return array of strings
     */
    public String[] parse(final String delimiter, final String sourse) {
        if (sourse == null || delimiter == null) {
            throw new NullPointerException();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int symbol;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(sourse)))) {
                while ((symbol = bufferedReader.read()) != -1) {
                    stringBuilder.append((char) symbol);
                }
            } catch (IOException e) {
                System.out.println("Error! File not found");
            }
            StringParser stringParser = new StringParser();
            return stringParser.parse(delimiter, stringBuilder.toString());
        }
    }
}
