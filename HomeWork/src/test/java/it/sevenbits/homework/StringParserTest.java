package it.sevenbits.homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


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
    public void stringParserFewWordSimpleDelimiterTest(){
        String str ="cats,dogs,mice,parrots";
        String[] strArray = {"cats", "dogs", "mice", "parrots"};
        Assert.assertArrayEquals(strArray, stringParser.parse(",", str));
    }
    @Test
    public void stringParserFewWordComplexDelimiterTest(){
        String str = "cats,,dogs,,mice,,parrots";
        String[] strArray = {"cats", "dogs", "mice", "parrots"};
        Assert.assertArrayEquals(strArray, stringParser.parse(",,", str));
    }
    @Test(expected = NullPointerException.class)
    public void stringParserNullTest(){
        String str = null;
        String[] strArray = stringParser.parse(", ", str);

    }
}
