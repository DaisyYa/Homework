package it.sevenbits.homework.Grep;


import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * class OrGrep in which the doGrep method is implemented
 */
public class OrGrep implements IGrep {
    private String[] filter;

    /**
     * constructor OrGrep
     * @param filter arrays of strings
     */
    public OrGrep(final String[] filter) {
        this.filter = filter;
    }
    private OrGrep() {
    }


    @Override
    public ArrayList<String> doGrep(final Reader reader) throws IOException, StreamIsEmptyException {
        ArrayList<String> stringArrayList = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int c;
        if ((c = reader.read()) == -1) {
            throw new StreamIsEmptyException("nothing to read from the stream");
        } else {
            while (c != -1) {
                if ((char) c == '\n') {
                    for (String str : filter) {
                        if (line.toString().toLowerCase().contains(str.toLowerCase())) {
                            stringArrayList.add(line.toString());

                            break;
                        }
                    }
                    line = new StringBuilder();
                } else {
                    line.append((char) c);
                }
                c = reader.read();
            }
            for (String str : filter) {
                if (line.toString().toLowerCase().contains(str.toLowerCase())) {
                    stringArrayList.add(line.toString());
                    break;
                }
            }
        }
        return stringArrayList;
    }
}
