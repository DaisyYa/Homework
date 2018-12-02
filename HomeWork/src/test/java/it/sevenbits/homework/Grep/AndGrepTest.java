package it.sevenbits.homework.Grep;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class AndGrepTest {
    @Test
    public void OneWordGrep1Test() throws IOException, StreamIsEmptyException {
        Reader reader = new BufferedReader(new FileReader(new File("src/test/java/resources/file1.txt")));
        GrepFactory grepFactory = new GrepFactory();
        String[] strings = {"dogs", "mice"};
        AndGrep andGrep = grepFactory.getAndGrep(strings);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("cats dogs mice");
        arrayList.add("dogs mice");
        Assert.assertEquals(arrayList, andGrep.doGrep(reader));
    }
    @Test(expected = StreamIsEmptyException.class)
    public void OneWordGrepEmptyFileTest() throws IOException, StreamIsEmptyException {
        Reader reader = new BufferedReader(new FileReader(new File("src/test/java/resources/test3.txt")));
        GrepFactory grepFactory = new GrepFactory();
        String[] strings = {"dogs", "mice"};
        AndGrep andGrep = grepFactory.getAndGrep(strings);
        andGrep.doGrep(reader);
    }
}
