package it.sevenbits.homework;

/**
 *  class with parse method(for string)
 */
public class StringParser implements IParser {
    /**
     *
     * @param delimiter specified delimiter
     * @param sourse string
     * @return array of strings
     */
    public String[] parse(final String delimiter, final String sourse) {
            return sourse.split(delimiter);
    }
}
