package it.sevenbits;
import it.sevenbits.homework.Parser;

import java.util.Arrays;

/**
 *  class with main method
 */
public class Main {
    /**
     *
     * @param args array of strings
     */
    public static  void main(final String[] args) {
        String str1 = "Text for    example ";
        Parser parser = new Parser();
        String[] astr = parser.parse(str1);
        System.out.println(Arrays.toString(astr));
    }
}
