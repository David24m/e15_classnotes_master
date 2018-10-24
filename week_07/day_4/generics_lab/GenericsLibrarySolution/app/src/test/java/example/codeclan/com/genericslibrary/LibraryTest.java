package example.codeclan.com.genericslibrary;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jaychetty on 14/09/2017.
 */

public class LibraryTest {
    @Test
    public void can_add_item(){
        Library<Book> lib = new Library<Book>();

        Book book = new Book();
        lib.addItem( book );

        assertEquals(1, lib.getItems().size());

    }
    @Test
    public void can_issue_item(){
        Library<Book> lib = new Library<Book>();
        Borrower<Book> sue = new Borrower<Book>();

        Book book = new Book();
        lib.addItem( book );
        lib.issueItem(sue);

        assertEquals(1, sue.getItems().size());
        assertEquals(0, lib.getItems().size());

    }

    @Test
    public void can_return_item(){
        Library<Book> lib = new Library<Book>();
        Borrower<Book> sue = new Borrower<Book>();

        Book book = new Book();
        sue.borrowItem( book );
        lib.returnItem(sue);

        assertEquals(0, sue.getItems().size());
        assertEquals(1, lib.getItems().size());

    }
}
