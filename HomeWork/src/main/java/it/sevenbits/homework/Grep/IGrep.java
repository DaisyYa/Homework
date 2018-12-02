package it.sevenbits.homework.Grep;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * implementation of the doGrep method
 */
public interface IGrep {
    /**
     * filters the stream of textual information
     * @param reader stream for which is done method
     * @return strings in which there is a filter
     * @throws IOException if you can't read
     */
    ArrayList<String> doGrep(Reader reader) throws IOException, StreamIsEmptyException;
}
