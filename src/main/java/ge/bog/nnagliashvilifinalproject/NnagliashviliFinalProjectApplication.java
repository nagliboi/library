package ge.bog.nnagliashvilifinalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "ge.bog.nnagliashvilifinalproject")
@EnableScheduling
public class NnagliashviliFinalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(NnagliashviliFinalProjectApplication.class, args);
    }

}
