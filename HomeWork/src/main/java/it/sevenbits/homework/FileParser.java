package it.sevenbits.homework;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *  class with parse method(for file)
 */
public class FileParser implements IParser {
    /**
     *
     * @param delimiter specified delimiter
     * @param sourse file path
     * @return array of strings
     */
    public String[] parse(final String delimiter, final String sourse) {
        String[] str = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(sourse)))) {
            str = bufferedReader.readLine().split(delimiter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return str;
    }
}
