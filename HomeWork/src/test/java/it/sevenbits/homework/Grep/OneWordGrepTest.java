package it.sevenbits.homework.Grep;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class OneWordGrepTest {
    /**
     * read lines and grep
     * @throws IOException if you can't read
     * @throws StreamIsEmptyException if nothing to read from the stream
     */
    @Test
    public void OneWordGrepTest() throws StreamIsEmptyException, IOException {
        Reader reader = new StringReader("Hello\n\nday\n");
        GrepFactory grepFactory = new GrepFactory();
        OneWordGrep oneWordGrep = grepFactory.getOneWordGrep("Hello");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        Assert.assertEquals(arrayList, oneWordGrep.doGrep(reader));
    }

    /**
     * if file is empty throw StreamIsEmptyException
     * @throws IOException if you can't read
     * @throws StreamIsEmptyException if nothing to read from the stream
     */
    @Test(expected = StreamIsEmptyException.class)
    public void OneWordGrepEmptyFileTest() throws IOException, StreamIsEmptyException {
        Reader reader = new BufferedReader(new FileReader(new File("src/test/java/resources/test3.txt")));
        GrepFactory grepFactory = new GrepFactory();
        OneWordGrep oneWordGrep = grepFactory.getOneWordGrep("dogs");
        oneWordGrep.doGrep(reader);
    }
}
