package it.sevenbits.homework.Grep;

import java.io.*;
import java.util.ArrayList;

/**
 * class OneWordGrep in which the doGrep method is implemented
 */
public class OneWordGrep implements IGrep {
    private String filter;

    /**
     * constructor OneWordGrep
     *
     * @param filter string
     */
    public OneWordGrep(final String filter) {
        this.filter = filter;
    }

    private OneWordGrep() {
    }


    @Override
    public ArrayList<String> doGrep(final Reader reader) throws IOException, StreamIsEmptyException {
        ArrayList<String> stringArrayList = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int c = 0;
        if ((c = reader.read()) == -1) {
            throw new StreamIsEmptyException("nothing to read from the stream");
        } else {
            while (c != -1) {
                if ((char) c == '\n') {
                    if (line.toString().toLowerCase().contains(filter.toLowerCase())) {
                        stringArrayList.add(line.toString());
                        line = new StringBuilder();
                    }
                } else {
                    line.append((char) c);
                }
                c = reader.read();
            }
            if (line.toString().toLowerCase().contains(filter.toLowerCase())) {
                stringArrayList.add(line.toString());
            }
        }
        return stringArrayList;
    }
}
