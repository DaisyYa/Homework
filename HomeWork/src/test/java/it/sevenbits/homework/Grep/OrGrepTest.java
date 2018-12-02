package it.sevenbits.homework.Grep;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class OrGrepTest {
    @Test
    public void OneWordGrep1Test() throws IOException, StreamIsEmptyException {
        Reader reader = new BufferedReader(new FileReader(new File("src/test/java/resources/file1.txt")));
        GrepFactory grepFactory = new GrepFactory();
        String[] strings = {"dogs", "mice"};
        OrGrep orGrep = grepFactory.getOrGrep(strings);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("cats dogs mice");
        arrayList.add("dogs mice");
        arrayList.add("cats dogs");
        Assert.assertEquals(arrayList, orGrep.doGrep(reader));
    }
    @Test(expected = StreamIsEmptyException.class)
    public void OneWordGrepEmptyFileTest() throws IOException, StreamIsEmptyException {
        Reader reader = new BufferedReader(new FileReader(new File("src/test/java/resources/test3.txt")));
        GrepFactory grepFactory = new GrepFactory();
        String[] strings = {"dogs", "mice"};
        OrGrep orGrep = grepFactory.getOrGrep(strings);
        orGrep.doGrep(reader);
    }
}
