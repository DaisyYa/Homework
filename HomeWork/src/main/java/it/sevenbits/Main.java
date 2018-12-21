package it.sevenbits;
import it.sevenbits.homework.Grep.*;
import it.sevenbits.homework.Parser.IParser;
import it.sevenbits.homework.Parser.Parser;
import it.sevenbits.homework.Parser.StringParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *  class with main method
 */
public class Main {
    /**
     * @param args array of strings
     */
    public static void main(final String[] args) throws IOException, StreamIsEmptyException {
        Reader reader;
        IGrep grep;
        String delimiter = (args[5] != null) ? args[5] : " ";
        IParser parser = new StringParser();
        String[] strings = parser.parse(delimiter, args[3]);
        switch (args[0]) {
            case "-f":
                reader = new BufferedReader(new FileReader(new File(args[1])));
                break;
            case "-s":
                reader = new StringReader(args[1]);
                break;
            default:
                throw new IllegalArgumentException("Error!Failed to create reader");
        }
        switch (args[2]) {
            case "-one":
                grep = new OneWordGrep(args[3]);
                break;
            case "-or":
                grep = new OrGrep(strings);
                break;
            case "-and":
                grep = new AndGrep(strings);
                break;
            default:
                throw new IllegalArgumentException("Error!Failed to create grep");
        }
        System.out.println(grep.doGrep(reader));
    }
}
