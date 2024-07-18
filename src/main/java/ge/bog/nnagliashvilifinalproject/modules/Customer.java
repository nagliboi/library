package ge.bog.nnagliashvilifinalproject.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String name;

    @Column
    private String email;

    @Column
    private String phone;

//
//    @JsonIgnore
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "customer_books",
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "book_id"))
//
//    private Set<Book> books = new HashSet<>();
}
