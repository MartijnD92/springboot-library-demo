package nl.doensenmartijn.library.service;

import nl.doensenmartijn.library.exception.RecordNotFoundException;
import nl.doensenmartijn.library.model.Book;
import nl.doensenmartijn.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(long id) {
        if (bookRepository.existsById(id)) {
            return bookRepository.findById(id).get();
        } else {
            throw new RecordNotFoundException("No book with id " + id);
        }
    }

    @Override
    public List<Book> getBooksTitleStartsWith(String title) {
        return bookRepository.findAllByTitleStartingWith(title);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteById(long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No book with id " + id);
        }
    }

}
