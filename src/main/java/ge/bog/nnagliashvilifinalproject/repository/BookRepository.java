package ge.bog.nnagliashvilifinalproject.repository;

import ge.bog.nnagliashvilifinalproject.modules.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Find a book by its ID
    @Override
    Optional<Book> findById(Long aLong);

    // Find a book by its name
    Optional<Book> findByName(String name);

    // Retrieve all books
    List<Book> findAll();

    // Find books by the customer ID (if there's a relation between books and customers)
    List<Book> findBooksById(Long customerId);
}
