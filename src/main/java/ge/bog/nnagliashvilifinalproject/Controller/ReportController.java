package ge.bog.nnagliashvilifinalproject.Controller;


import ge.bog.nnagliashvilifinalproject.dto.BookReserve;
import ge.bog.nnagliashvilifinalproject.modules.Book;
import ge.bog.nnagliashvilifinalproject.modules.CustomerBook;
import ge.bog.nnagliashvilifinalproject.service.BookService;
import ge.bog.nnagliashvilifinalproject.service.CsvService;
import org.hibernate.annotations.GeneratedColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    BookService bookService;

    @Autowired
    CsvService csvService;


    @GetMapping("/CSV")
    public ResponseEntity<StreamingResponseBody> downloadReservedBooksCsv() {
        StreamingResponseBody stream = outputStream -> {
            List<CustomerBook> reservedBooks = csvService.getReservedButNotReturnedBooks();
            try (Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
                writer.write("CustomerId,BookName\n"); // CSV header
                for (CustomerBook customerBook : reservedBooks) {
                    writer.write(customerBook.getCustomerId() + "," + customerBook.getBookName() + "\n");
                }
            }
        };

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("text/csv; charset=UTF-8"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reserved_books.csv")
                .body(stream);
    }


        @GetMapping("/allBooksCnt")
    public List<BookReserve> getAllBooksCnt() {
        return bookService.getAllBooksCnt();
    }
}
