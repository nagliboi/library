package ge.bog.nnagliashvilifinalproject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ge.bog.nnagliashvilifinalproject.dto.bookRefreshInfo;
import ge.bog.nnagliashvilifinalproject.modules.Book;
import ge.bog.nnagliashvilifinalproject.repository.BookRepository;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApiService implements ApiServiceInt {

    private final BookRepository bookRepository;

    public ApiService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Scheduled(cron = "0 33 23 * * *") // Runs at 1:00 AM every day
    public void callExternalApiScheduled() {
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            if (!book.getRefreshed()) {

                String name = book.getName(); // Replace with actual book name or pass as parameter
                try {
                    bookRefreshInfo info = callExternalApi(name);
                    book.setNumFound(info.getNumFound());
                    book.setRefreshed(true);
                    book.setStart(info.getStart());
                    bookRepository.save(book);
                    System.out.println("API call successful for book: " + name);

                } catch (Exception e) {
                    System.err.println("Error calling external API: " + e.getMessage());
                }
            }
        }
    }

    public static bookRefreshInfo callExternalApi(String name) throws KeyStoreException, KeyManagementException, JsonProcessingException {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(Duration.ofSeconds(90)); // 90 seconds
        requestFactory.setReadTimeout(Duration.ofSeconds(90)); // 90 seconds
        requestFactory.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("thegate.bog.ge", 8080)));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(requestFactory);

        restTemplate.setInterceptors(
                List.of(new ClientHttpRequestInterceptor() {
                    @Override
                    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
                        System.out.println("Request: " + request.getURI());
                        System.out.println("Request headers: " + request.getHeaders());
                        return execution.execute(request, body);
                    }
                })
        );

        // Create HttpHeaders instance and set headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("Connection", "keep-alive");
        headers.set("Accept", "*/*");
        headers.set("Keep-Alive", "1000");
        headers.set("Cache-Control", "no-cache");
        headers.set("User-Agent", "PostmanRuntime/7.37.3");
        headers.set("Host", "openlibrary.org");
        headers.set("Accept-Encoding", "gzip, deflate, br");
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        // Use the HttpEntity in the RestTemplate exchange method
        ResponseEntity<String> response = restTemplate.exchange("http://openlibrary.org/search.json?q=" + name,
                HttpMethod.GET, entity, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.getBody(), bookRefreshInfo.class);
    }
}
