package it.sevenbits.homework;

import java.util.ArrayList;

/**
 *  class with parse method(for string)
 */
public class StringParser implements IParser {
    /**
     * separates the words in string
     * @param delimiter specified delimiter
     * @param sourse string
     * @return array of strings
     */
    public String[] parse(final String delimiter, final String sourse) {
        String s = sourse.trim().replaceAll(" +", " ");
        ArrayList<String> arrayList = new ArrayList<String>();
        int q = 0;
        int delN = 0;
        if (delimiter.length() == 1) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == delimiter.charAt(0)) {
                    arrayList.add(s.substring(q, i));
                    q = i + 1;
                }
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (delimiter.contains(String.valueOf(s.charAt(i)))) {
                    delN++;
                    if (delN == delimiter.length()) {
                        arrayList.add(s.substring(q, i - delimiter.length() + 1));
                        q = i + 1;
                        delN = 0;
                    }
                }
            }
        }
        arrayList.add(s.substring(q));
        return arrayList.toArray(new String[arrayList.size()]);
    }
}
