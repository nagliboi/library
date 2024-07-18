package ge.bog.nnagliashvilifinalproject.service;

import ge.bog.nnagliashvilifinalproject.exception.*;
import ge.bog.nnagliashvilifinalproject.modules.Customer;

public interface CustomerServiceInt {

    Customer registerCustomer(Customer customer);

    String reserveBook(Long customerId, String bookName) throws CustomerNotFoundException, BookNotFoundException, BookAlreadyReservedException, BookNotLeftException;

    String returnBook(Long customerId, String bookName) throws CustomerNotFoundException, BookNotFoundException, BookNotReservedException;

    String rateBook(Long customerId, String bookName, Integer stars) throws CustomerNotFoundException, BookNotFoundException, BookNotReservedException, RatingOutOfRangeException, BookNotReturnedException;
}
