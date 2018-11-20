package it.sevenbits.homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class FileParserTest {
    private FileParser fileParser;

    @Before
    public void setUp() {
        this.fileParser = new FileParser();
    }
    @Test
    public void fileParserOneWordTest(){
        String[] strArray = {"Hello"};
        Assert.assertArrayEquals(strArray, fileParser.parse(" ", "src/test/java/resources/test1.txt"));
    }
    @Test
    public void fileParserFewWordSimpleDelimiterTest(){
        String[] strArray = {"cats", "dogs", "mice", "etc"};
        Assert.assertArrayEquals(strArray, fileParser.parse(",", "src/test/java/resources/test2.txt"));
    }
    @Test(expected = NullPointerException.class)
    public void fileParserNullTest() {
        String[] strArray = fileParser.parse(", ", null);
    }
    @Test(expected = NullPointerException.class)
    public void fileParserEmptyFileTest(){
        String[] strArray = fileParser.parse(", ", "src/test/java/resources/test3.txt");
    }
    @Test
    public void fileParserFewWordComplexDelimiterTest(){
        String[] strArray = {"cats", "dogs", "mice", "parrots"};
        Assert.assertArrayEquals(strArray, fileParser.parse(", ", "src/test/java/resources/test4.txt"));
    }

}
