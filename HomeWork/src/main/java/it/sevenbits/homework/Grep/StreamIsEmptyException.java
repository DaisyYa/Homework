package it.sevenbits.homework.Grep;

/**
 * class StreamIsEmptyException
 */
public class StreamIsEmptyException extends Exception {
    /**
     *constructor StreamIsEmptyException
     * @param s error message
     */
    public StreamIsEmptyException(final String s) {
        super(s);
    }
}
