package dresen.hibernatelibrary;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HibernateLibrary {
    public static void main(String[] args) {


        // this starts a new factorySession and instantiates one copy of DAOFile.
        DAOFile t = DAOFile.getInstance();

        // add books

        Integer bSanderson = t.addAuthor("Brandon", "Sanderson");
        Integer oCard = t.addAuthor("Orson Scott", "Card");
        Integer oCard2 = t.addAuthor("Orson Scott", "Card");
        Integer sMeyer = t.addAuthor("Stephanie", "Meyer");
        Integer bookId1 = t.addBook("The Chemist", "Innocent torturer has to run for her life.", sMeyer );
        Integer bookId2 = t.addBook("SteelHeart", "Man of Steel, but twisted.", bSanderson);
        Integer bookId3 = t.addBook("Ender's Game", "Kid kicks alien butt", oCard);
        Integer bookId4 = t.addBook("Host", "Aliens, parasites, and love", sMeyer);
        Integer bookId5 = t.addBook("Host", "Aliens, parasites, and love", sMeyer);



        // read books

        List<Book> library = t.getLibrary();




        System.out.print("\nLibrary:\n");
        for (Iterator iterator = library.iterator(); ((Iterator) iterator).hasNext(); ) {
            Book book = (Book) iterator.next();
            System.out.println("Title: " + book.getTitle() + " Description: " + book.getDescription() + " Author: " + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName());
        }


        Book abook = t.getBook(bookId2);



        Author author = t.getAuthor(sMeyer);
        System.out.println("\nAuthor: " + author.getFirstName() + " " + author.getLastName());
        System.out.println("Books: ");
        for (Book book : author.getBooks()) {
            System.out.println("Title: " + book.getTitle() + " Description: " + book.getDescription());
        }

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
