package ge.bog.nnagliashvilifinalproject.service;

import ge.bog.nnagliashvilifinalproject.dto.BookRefresh;
import ge.bog.nnagliashvilifinalproject.dto.BookReserve;
import ge.bog.nnagliashvilifinalproject.exception.BookAlreadyExistsException;
import ge.bog.nnagliashvilifinalproject.exception.BookAlreadyRefreshedException;
import ge.bog.nnagliashvilifinalproject.exception.BookNotActiveException;
import ge.bog.nnagliashvilifinalproject.exception.BookNotFoundException;
import ge.bog.nnagliashvilifinalproject.modules.Book;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.util.List;
import java.util.Optional;

public interface BookServiceInt {

    Book registerBook(String name, Long quantity) throws BookAlreadyExistsException;

    String deactivateBook(Long id) throws BookNotFoundException, BookNotActiveException;

    String activateBook(Long id) throws BookNotFoundException, BookAlreadyExistsException;

    List<Book> getAllBooks() throws BookNotFoundException;

    List<Book> getBooksByCustomer(Long customerId) throws BookNotFoundException, BookAlreadyExistsException;

    Book getBooksFromApi(String bookName) throws IOException, KeyStoreException, KeyManagementException, BookAlreadyRefreshedException, BookNotFoundException;

    Optional<Book> getBook(Long bookID);

    List<BookRefresh> getRefreshedBooks();

    List<BookReserve> getAllBooksCnt();
}
