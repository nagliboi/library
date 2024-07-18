package ge.bog.nnagliashvilifinalproject.repository;

import ge.bog.nnagliashvilifinalproject.modules.CustomerBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerBookRepository extends JpaRepository<CustomerBook, Long> {

    // Check if a book is reserved by a customer
    static boolean existsByCustomerIdAndBookName(Long customerId, String bookName) {
        return false;
    }

    // Find customer books by customer ID and book name
    CustomerBook findByCustomerIdAndBookName(Long customerId, String bookName);

    // Find all books reserved by a customer using customer ID
    List<CustomerBook> findByCustomerId(Long customerId);

    // Find all books that are reserved but not returned
    @Query("SELECT cb FROM CustomerBook cb WHERE cb.returned = false")
    List<CustomerBook> findNotReturnedBooks();

}
