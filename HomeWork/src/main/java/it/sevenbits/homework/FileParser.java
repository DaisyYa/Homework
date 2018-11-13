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
        String str = null;
        ArrayList<String> arrayList = new ArrayList<String>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(sourse)))) {
            str = bufferedReader.readLine().trim().replaceAll(" +", " ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        int q = 0;
        int delN = 0;
        if (delimiter.length() == 1) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == delimiter.charAt(0)) {
                    arrayList.add(str.substring(q, i));
                    q = i + 1;
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (delimiter.contains(String.valueOf(str.charAt(i)))) {
                    delN++;
                    if (delN == delimiter.length()) {
                        arrayList.add(str.substring(q, i - delimiter.length() + 1));
                        q = i + 1;
                        delN = 0;
                    }
                }
            }
        }
        arrayList.add(str.substring(q));

        return arrayList.toArray(new String[arrayList.size()]);
    }
}
