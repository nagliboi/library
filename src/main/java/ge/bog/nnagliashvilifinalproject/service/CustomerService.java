package ge.bog.nnagliashvilifinalproject.service;

import ge.bog.nnagliashvilifinalproject.exception.*;
import ge.bog.nnagliashvilifinalproject.modules.Book;
import ge.bog.nnagliashvilifinalproject.modules.Customer;
import ge.bog.nnagliashvilifinalproject.modules.CustomerBook;
import ge.bog.nnagliashvilifinalproject.repository.BookRepository;
import ge.bog.nnagliashvilifinalproject.repository.CustomerBookRepository;
import ge.bog.nnagliashvilifinalproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService implements CustomerServiceInt {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomerBookRepository customerBookRepository;

    // Registers a new customer in the repository
    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Reserves a book for a customer
    // verafrit ver gavaswore, 2jer ertidaigive wigns tu ar daarezerveb yvelaferi mushaobs
    // gviania agar shemidzlia
    @Transactional
    public String reserveBook(Long customerId, String bookName) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
        Book book = bookRepository.findByName(bookName).orElseThrow(BookNotFoundException::new);

        if (book.getQuantity() == 0L) {
            throw new BookNotLeftException();
        }

        if (CustomerBookRepository.existsByCustomerIdAndBookName(customerId, bookName)) {
            CustomerBook customerBook = customerBookRepository.findByCustomerIdAndBookName(customerId, book.getName());
            if (!customerBook.getReturned()) {
                throw new BookAlreadyReservedException();
            } else {
                book.setQuantity(book.getQuantity() - 1L);
                book.setReservedCnt(book.getReservedCnt() + 1L);
                customerBook.setReturned(false);

                customerBookRepository.save(customerBook);
                bookRepository.save(book);
                customerRepository.save(customer);

                return customer.getName() + " reserved " + bookName;

            }

        } else {

            CustomerBook customerBook = new CustomerBook();
            customerBook.setBookName(bookName);
            customerBook.setCustomerId(customerId);
            customerBook.setReturned(false);
            book.setQuantity(book.getQuantity() - 1L);
            book.setReservedCnt(book.getReservedCnt() + 1L);

            customerBookRepository.save(customerBook);
            bookRepository.save(book);
            customerRepository.save(customer);

        }

        return customer.getName() + " reserved " + bookName;

    }


// Returns a book for a customer
public String returnBook(Long customerId, String bookName) {
    Customer customer = customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
    Book book = bookRepository.findByName(bookName).orElseThrow(BookNotFoundException::new);

    CustomerBook customerBook = customerBookRepository.findByCustomerIdAndBookName(customerId, book.getName());
    if (customerBook == null) {
        throw new BookNotReservedException();
    } else if (customerBook.getReturned()) {
        throw new BookAlreadyReturnedException();
    } else {

        customerBook.setReturned(true);
        book.setQuantity(book.getQuantity() + 1);

        bookRepository.save(book);
        customerBookRepository.save(customerBook);
        customerRepository.save(customer);
        return customer.getName() + " returned " + bookName;
    }
}

// Rates a book by a customer
public String rateBook(Long customerId, String bookName, Integer stars) {
    Customer customer = customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
    Book book = bookRepository.findByName(bookName).orElseThrow(BookNotFoundException::new);
    CustomerBook customerBook = customerBookRepository.findByCustomerIdAndBookName(customerId, bookName);
    if (customerBook == null) {
        throw new BookNotReservedException();
    } else {

        if (customerBook.getReturned()) {
            if (stars > 0 && stars <= 5) {
                customerBook.setRating(stars);
                customerBookRepository.save(customerBook);
            } else {
                throw new RatingOutOfRangeException();
            }
        } else {
            throw new BookNotReturnedException();
        }
    }
    return book.getName() + " rated as " + stars + " stars by " + customer.getName();
}
}
