package it.sevenbits.homework.Grep;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class OneWordGrepTest {
    @Test
    public void OneWordGrep1Test() throws IOException, StreamIsEmptyException {
        Reader reader = new StringReader("Hello d");
        GrepFactory grepFactory = new GrepFactory();
        OneWordGrep oneWordGrep = grepFactory.getOneWordGrep("Hello");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello d");
        Assert.assertEquals(arrayList, oneWordGrep.doGrep(reader));
    }
    @Test(expected = StreamIsEmptyException.class)
    public void OneWordGrepEmptyFileTest() throws IOException, StreamIsEmptyException {
        Reader reader = new BufferedReader(new FileReader(new File("src/test/java/resources/test3.txt")));
        GrepFactory grepFactory = new GrepFactory();
        String string = "dogs";
        OneWordGrep oneWordGrep = grepFactory.getOneWordGrep(string);
        oneWordGrep.doGrep(reader);
    }
}
