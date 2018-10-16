package it.sevenbits.homework;

public class Main {
    public static  void main(String[] args){
        String str1 ="Text for    example ";
        Parser parser =new Parser();
        String[] astr =parser.parse(str1);

        for (int i =0; i<astr.length; i++){
            System.out.print("["+astr[i]+"]");
        }

    }
}
