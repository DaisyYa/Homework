package it.sevenbits.homework.Grep;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * class AndGrep in which the doGrep method is implemented
 */
public class AndGrep implements IGrep {
    private String[] filter;

    /**
     * constructor AndGrep
     * @param filter array of strings
     */
    public AndGrep(final String[] filter) {
        this.filter = filter;
    }
    private AndGrep() {
    }

    @Override
    public ArrayList<String> doGrep(final Reader reader) throws IOException, StreamIsEmptyException {
        ArrayList<String> stringArrayList = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int count = 0;
        int c = 0;
        if ((c = reader.read()) == -1) {
            throw  new StreamIsEmptyException("nothing to read from the stream");
        } else {
        while (c != -1) {
            if ((char) c == '\n') {
                for (String str : filter) {
                    if (line.toString().toLowerCase().contains(str.toLowerCase())) {
                        count++;
                    }
                }
                if (count == filter.length) {
                    stringArrayList.add(line.toString());
                    count = 0;
                }
                line = new StringBuilder();
            } else {
                line.append((char) c);
            }
            c = reader.read();
        }
        for (String str : filter) {
            if (line.toString().toLowerCase().contains(str.toLowerCase())) {
                count++;
            }
        }
        if (count == filter.length) {
            stringArrayList.add(line.toString());
        }
    }
        return stringArrayList;
    }
}
