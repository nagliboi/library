package ge.bog.nnagliashvilifinalproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

//dto for rating funtionality
public class RateRequest {
    private String bookTitle;
    private Long customerId;
    private Integer stars;
}
