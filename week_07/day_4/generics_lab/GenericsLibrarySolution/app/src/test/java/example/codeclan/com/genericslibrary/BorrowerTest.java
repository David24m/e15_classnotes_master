package example.codeclan.com.genericslibrary;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jaychetty on 14/09/2017.
 */

public class BorrowerTest {
    @Test
    public void can_borrow_items(){
        Borrower<Book> sue = new Borrower<Book>();
        Book book = new Book();
        sue.borrowItem( book );
        assertEquals(1, sue.getItems().size());
    }
    @Test
    public void gives_last_item(){
        Borrower<Book> sue = new Borrower<Book>();
        Book book = new Book();
        sue.borrowItem( book );
        Book returnedBook = sue.getLastItem();
        assertEquals(book, returnedBook);
        assertEquals(0, sue.getItems().size());
    }
}
