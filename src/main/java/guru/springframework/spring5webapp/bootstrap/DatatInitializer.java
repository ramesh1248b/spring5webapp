package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatatInitializer implements CommandLineRunner {
    private final BookRepository bookRepository ;
    //private Book book;
    public DatatInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void run(String... args) throws Exception {
        Book BookDOD = new Book("Domain Driven Design", "10001", "Random House");
        System.out.println("Id = " + BookDOD.getId());
        BookDOD = bookRepository.save(BookDOD);
        System.out.println("Id = " + BookDOD.getId());

        Book BookSIA = new Book("Spring in Action", "10002", "Orielly");
        System.out.println("Id = " + BookSIA.getId());
        BookSIA = bookRepository.save(BookSIA);
        System.out.println("Id = " + BookSIA.getId());

        for (Book book : bookRepository.findAll()) {
            System.out.println(book.toString());
        }
    }
}
