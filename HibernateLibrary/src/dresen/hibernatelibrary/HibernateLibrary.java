package dresen.hibernatelibrary;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HibernateLibrary {
    public static void main(String[] args) {


        // this starts a new factorySession and instantiates one copy of DAOFile.
        DAOFile t = DAOFile.getInstance();

        // add books

        Integer bookId1 = t.addBook("The Chemist", "Innocent torturer has to run for her life.");
        Integer bookId2 = t.addBook("SteelHeart", "Man of Steel, but twisted.");
        Integer bookId3 = t.addBook("Ender's Game", "Kid kicks alien butt");
        Integer bookId4 = t.addBook("Host", "Aliens, parasites, and love");

        // read books

        List<Book> library = t.getLibrary();




        System.out.print("\nLibrary");
        for (Iterator iterator = library.iterator(); ((Iterator) iterator).hasNext(); ) {
            Book book = (Book) iterator.next();
            System.out.println("Title: " + book.getTitle() + " Description: " + book.getDescription());
        }
        Book abook = t.getBook(bookId2);

        // update books
        abook = t.updateBook(abook.getId(), abook.getTitle(), "UpdatedDescription");
        System.out.println("\nUpdated book: " + abook);

        // delete books
        String message = t.deleteBook(bookId1);
        System.out.println("\n " + message);


        // shut down before closing
        HibernateUtil.shutdown();

    }
}
