package it.sevenbits.homework;
import java.util.Arrays;

public class Main {
    public static  void main(String[] args){
        String str1 ="Text for    example ";
        Parser parser =new Parser();
        String[] astr =parser.parse(str1);
        System.out.println(Arrays.toString(astr));
    }
}
