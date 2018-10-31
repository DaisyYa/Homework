package it.sevenbits.homework;
import java.util.ArrayList;

/**
 *  class Parser with parse method
 */
public class Parser {
    /**
     *
     * @param str input string
     * @return array of strings
     */
    public String[] parse(final String str) {
        String s = str.trim().replaceAll(" +", " ");
        ArrayList<String> arrayList = new ArrayList<String>();
        int q = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                arrayList.add(s.substring(q, i));
                q = i + 1;
            }
        }
            arrayList.add(s.substring(q));

        return arrayList.toArray(new String[arrayList.size()]);
    }
}
