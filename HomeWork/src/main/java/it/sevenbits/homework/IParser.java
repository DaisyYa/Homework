package it.sevenbits.homework;

/**
 * Interface with parse method
 */
public interface IParser {
    /**
     *
     * @param delimiter specified delimiter
     * @param sourse file path or string
     * @return array of strings
     */
    String[] parse(String delimiter, String sourse);
}
