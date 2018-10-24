package example.codeclan.com.genericslibrary;

import java.util.ArrayList;

/**
 * Created by jaychetty on 14/09/2017.
 */

public class Borrower<T> {
    private ArrayList<T> items;

    public ArrayList<T> getItems(){
        return items;
    }
    public Borrower(){
        this.items = new ArrayList<T>();
    }

    public void borrowItem(T item){
        items.add(item);
    }

    public T getLastItem(){
        return items.remove(items.size() - 1);
    }
}
