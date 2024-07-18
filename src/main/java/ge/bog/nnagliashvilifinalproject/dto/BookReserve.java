package ge.bog.nnagliashvilifinalproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

//dto for returning when we count how many times the book has been reserved
public class BookReserve {
    private Long id;
    private String bookName;
    private Long ReservedCnt;



}
