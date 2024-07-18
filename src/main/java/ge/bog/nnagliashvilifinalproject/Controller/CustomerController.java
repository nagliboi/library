package ge.bog.nnagliashvilifinalproject.Controller;


import ge.bog.nnagliashvilifinalproject.dto.BookRefresh;
import ge.bog.nnagliashvilifinalproject.dto.BookRequest;
import ge.bog.nnagliashvilifinalproject.dto.RateRequest;
import ge.bog.nnagliashvilifinalproject.modules.Book;
import ge.bog.nnagliashvilifinalproject.modules.Customer;
import ge.bog.nnagliashvilifinalproject.service.BookService;
import ge.bog.nnagliashvilifinalproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    BookService bookService;

    @Autowired
    CustomerService customerService;

    @PostMapping("/registration")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer);
    }

    @PutMapping("/reserve")
    public String reserveBook(@RequestBody BookRequest bookRequest) {
        return customerService.reserveBook(bookRequest.getCustomerId(), bookRequest.getBookTitle());
    }

    @PutMapping("/return")
    public String returnBook(@RequestBody BookRequest bookRequest) {
        return customerService.returnBook(bookRequest.getCustomerId(), bookRequest.getBookTitle());
    }

    @PutMapping("/rate")
    public String rateBook(@RequestBody RateRequest rateRequest) {
        return customerService.rateBook(rateRequest.getCustomerId(), rateRequest.getBookTitle(), rateRequest.getStars());
    }

    @GetMapping("/refreshedBooks")
    public List<BookRefresh> getRefreshed() {
        return bookService.getRefreshedBooks();
    }



}
