package example.codeclan.com.dependencyinversionfixed;

/**
 * Created by user on 27/06/2017.
 */

import java.util.ArrayList;

public class Macbook implements Journal{

    private ArrayList<String> journalEntries;

    public Macbook(){
        journalEntries = new ArrayList<String>();
    }

    public void write(String text){
        this.journalEntries.add(text);
    }

    public String readLast(){
        return journalEntries.get(journalEntries.size() - 1);
    }

}
