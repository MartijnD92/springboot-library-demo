package nl.doensenmartijn.library.repository;


import nl.doensenmartijn.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitleStartingWith(String title);
}