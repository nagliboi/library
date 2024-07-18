package ge.bog.nnagliashvilifinalproject.service;

import ge.bog.nnagliashvilifinalproject.modules.CustomerBook;

import java.io.IOException;
import java.util.List;

public interface CsvServiceInt {

    /**
     * Retrieve a list of books that are reserved but not yet returned.
     *
     * @return a list of CustomerBook objects.
     */
    List<CustomerBook> getReservedButNotReturnedBooks();

    /**
     * Generate a CSV file containing the list of reserved but not returned books.
     *
     * @return the name of the generated CSV file.
     * @throws IOException if an I/O error occurs.
     */
    String generateReservedBooksCSV() throws IOException;
}
