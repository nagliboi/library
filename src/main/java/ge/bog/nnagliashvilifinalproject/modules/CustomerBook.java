package ge.bog.nnagliashvilifinalproject.modules;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "customer_book", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"customerId", "bookName"})
})
public class CustomerBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private String bookName;

    //a flag to determine if it is returned
    private Boolean returned = false;

    //for customers to rate
    private Integer rating;

    }

