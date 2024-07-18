package ge.bog.nnagliashvilifinalproject.exception;

public class BookNotReturnedException extends RuntimeException {
    public BookNotReturnedException() {
        super("Book is not returned bro");
    }
}
