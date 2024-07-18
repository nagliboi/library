package ge.bog.nnagliashvilifinalproject.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Boolean active = true;

    @Column
    private Long quantity;

    @Column
    private Boolean refreshed = false;

    //for counting how many times book has been reserved
    @Column
    private Long ReservedCnt = 0L;

    //for api
    @Column
    private Integer numFound;

    //for api
    @Column
    private Integer start;

//
//    @JsonIgnore
//    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
//    private Set<Customer> customers = new HashSet<>();

}
