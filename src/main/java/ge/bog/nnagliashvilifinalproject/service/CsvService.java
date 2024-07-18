package ge.bog.nnagliashvilifinalproject.service;

import ge.bog.nnagliashvilifinalproject.modules.CustomerBook;
import ge.bog.nnagliashvilifinalproject.repository.CustomerBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CsvService {

    @Autowired
    private CustomerBookRepository customerBookRepository;

    // Scheduled task to run once every 24 hours
//    @Scheduled(cron = "0 0 0 */1 * *")
    @Scheduled(cron = "0 48 20 * * *")
    public void generateDailyReservedBooksCSV() {
        try {
            List<CustomerBook> reservedBooks = customerBookRepository.findNotReturnedBooks();

            String csvFileName = "reserved_books_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".csv";
            try (FileWriter writer = new FileWriter(csvFileName)) {
                writer.append("CustomerId,BookName\n");
                for (CustomerBook customerBook : reservedBooks) {
                    writer.append(customerBook.getCustomerId().toString())
                            .append(',')
                            .append(customerBook.getBookName())
                            .append('\n');
                }
            }
            System.out.println("Daily CSV report generated: " + csvFileName);
        } catch (IOException e) {
            System.err.println("Error generating daily CSV report: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to get reserved but not returned books (optional)
    public List<CustomerBook> getReservedButNotReturnedBooks() {
        return customerBookRepository.findNotReturnedBooks();
    }
}
