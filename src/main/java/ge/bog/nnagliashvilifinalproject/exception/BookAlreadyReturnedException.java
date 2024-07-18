package ge.bog.nnagliashvilifinalproject.exception;

public class BookAlreadyReturnedException extends RuntimeException {
    public BookAlreadyReturnedException() {
        super("Book already returned bro");
    }
}
