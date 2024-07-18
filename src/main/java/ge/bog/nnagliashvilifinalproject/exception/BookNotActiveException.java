package ge.bog.nnagliashvilifinalproject.exception;

public class BookNotActiveException extends RuntimeException {
    public BookNotActiveException() {
        super("Book is already not active bro");
    }
}
