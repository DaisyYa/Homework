package it.sevenbits.homework;
import java.util.ArrayList;

public class Parser {

    public String[] parse(String str){
        String s=str.trim().replaceAll( " +"," " );
        ArrayList<String> arrayList=new ArrayList<String>( );
        int q=0;

        for (int i=0; i<s.length(); i++){
            if(s.charAt( i )==' '){
                arrayList.add( s.substring( q, i ) );
                q=i+1;
            }
        }
        if(q<s.length()){
            arrayList.add( s.substring( q ) );
        }
        return arrayList.toArray( new String[arrayList.size()] );
    }
}
