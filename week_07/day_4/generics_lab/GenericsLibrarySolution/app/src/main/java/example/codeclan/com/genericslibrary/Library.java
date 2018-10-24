package example.codeclan.com.genericslibrary;

import java.util.ArrayList;

/**
 * Created by jaychetty on 14/09/2017.
 */

public class Library<T> {
    private ArrayList<T> items;
    public Library(){
        this.items = new ArrayList<T>();
    }
    public ArrayList<T> getItems(){
        return items;
    }

    public void addItem(T item){
        items.add(item);
    }

    public void issueItem(Borrower<T> borrower){
        T item = items.remove(items.size() - 1);
        borrower.borrowItem(item);
    }

    public void returnItem(Borrower<T> borrower){
        T item = borrower.getLastItem();
        this.addItem(item);
    }



}
