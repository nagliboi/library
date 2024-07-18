package ge.bog.nnagliashvilifinalproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter

//dto for storing refresh info
public class bookRefreshInfo {
    private Integer numFound;
    private Integer start;
    private Boolean numFoundExact;
    private List<Object> docs;
    private Long num_found;
    private String q;
    private String offset;
}
