package it.sevenbits.homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class StringParserTest {
    private StringParser stringParser;

    @Before
    public void setUp() {
        this.stringParser = new StringParser();
    }

    @Test
    public void stringParserOneWordTest(){
        String str ="Hello";
        String[] strArray = {"Hello"};
        Assert.assertArrayEquals(strArray, stringParser.parse(" ", str));
    }
    @Test
    public void stringParserFewWordTest(){
        String str ="cats, dogs, mice, etc";
        String[] strArray = {"cats", "dogs", "mice", "etc"};
        Assert.assertArrayEquals(strArray, stringParser.parse(", ", str));
    }
    @Test
    public void stringParserNullTest(){
        String str = null;
        try {
            String[] strArray = stringParser.parse(", ", str);
            fail();
        } catch (NullPointerException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }
}
