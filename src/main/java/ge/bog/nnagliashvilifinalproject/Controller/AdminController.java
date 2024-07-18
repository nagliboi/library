package ge.bog.nnagliashvilifinalproject.Controller;

import ge.bog.nnagliashvilifinalproject.dto.BookRefresh;
import ge.bog.nnagliashvilifinalproject.modules.Book;
import ge.bog.nnagliashvilifinalproject.service.BookService;
import ge.bog.nnagliashvilifinalproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")

public class AdminController {

    @Autowired
    BookService bookService;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public Book registerBook(@RequestBody Book book) {
        return bookService.registerBook(book.getName(), book.getQuantity());
    }

    @PutMapping("/deactivate/{id}")
    public String deactivateBook(@PathVariable Long id){
        return bookService.deactivateBook(id);
    }

    @PutMapping("/activate/{id}")
    public String activateBook(@PathVariable Long id){
        return bookService.activateBook(id);
    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/getByUser/{id}")
    public List<Book> getBooksByUser(@PathVariable Long id){
        return bookService.getBooksByCustomer(id);
    }

    @GetMapping("/refresh/{bookName}")
    public Book getBook(@PathVariable String bookName) throws IOException, KeyStoreException, KeyManagementException {
        return bookService.getBooksFromApi(bookName);
    }

    @GetMapping("/get/{bookID}")
    public Optional<Book> GetBookById(@PathVariable Long bookID){
        return bookService.getBook(bookID);
    }


}






