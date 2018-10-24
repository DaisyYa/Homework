package it.sevenbits.homework;

public class main {
    public static void main(String[] args){
        String str1=" Lfif      lf lf               ghbikf ljvjq nhb ckjdf     ";
        Parser parser=new Parser();
        String[] r=parser.parse( str1 );
        for (int i = 0; i < r.length; i++)
            System.out.print(" ["+r[i]+"] ");

    }
}
