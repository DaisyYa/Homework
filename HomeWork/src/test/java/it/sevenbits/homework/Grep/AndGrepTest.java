package it.sevenbits.homework.Grep;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class AndGrepTest {
    /**
     *  read lines and grep
     * @throws IOException if you can't read
     * @throws StreamIsEmptyException if nothing to read from the stream
     */
    @Test
    public void andGrepTest() throws IOException, StreamIsEmptyException {
        Reader reader = new BufferedReader(new FileReader(new File("src/test/java/resources/file1.txt")));
        GrepFactory grepFactory = new GrepFactory();
        String[] strings = {"dogs", "mice"};
        AndGrep andGrep = grepFactory.getAndGrep(strings);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("cats dogs mice");
        arrayList.add("dogs mice");
        Assert.assertEquals(arrayList, andGrep.doGrep(reader));
    }

    /**
     * if file is empty throw StreamIsEmptyException
     * @throws IOException if you can't read
     * @throws StreamIsEmptyException if nothing to read from the stream
     */
    @Test(expected = StreamIsEmptyException.class)
    public void andGrepGrepEmptyFileTest() throws IOException, StreamIsEmptyException {
        Reader reader = new BufferedReader(new FileReader(new File("src/test/java/resources/test3.txt")));
        GrepFactory grepFactory = new GrepFactory();
        String[] strings = {"dogs", "mice"};
        AndGrep andGrep = grepFactory.getAndGrep(strings);
        andGrep.doGrep(reader);
    }
}
