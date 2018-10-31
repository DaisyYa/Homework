package it.sevenbits.homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static junit.framework.TestCase.fail;

public class FileParserTest {
    private FileParser fileParser;

    @Before
    public void setUp() {
        this.fileParser = new FileParser();
    }
    @Test
    public void fileParserOneWordTest(){
        String[] strArray = {"Hello"};
        Assert.assertArrayEquals(strArray, fileParser.parse(" ", "test1.txt"));
    }
    @Test
    public void fileParserFewWordTest(){
        String[] strArray = {"cats", "dogs", "mice", "etc"};
        Assert.assertArrayEquals(strArray, fileParser.parse(", ", "test2.txt"));
    }
    @Test
    public void stringParserNullTest(){
        try {
            String[] strArray = fileParser.parse(", ", null);
            fail();
        } catch (NullPointerException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }
    @Test
    public void stringParserEmptyFileTest(){
        try {
            String[] strArray = fileParser.parse(", ", "test3.txt");
            fail();
        } catch (NullPointerException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }
}
