package example.codeclan.com.singleresponsibilityfixed;

/**
 * Created by user on 27/06/2017.
 */

import java.util.ArrayList;

public class Diary implements Journal{

    private ArrayList<String> journalEntries;

    public Diary(){
        journalEntries = new ArrayList<String>();
    }

    public void write(String text){
        this.journalEntries.add(text);
    }

    public String readLast(){
        return journalEntries.get(journalEntries.size() - 1);
    }

}
