package ge.bog.nnagliashvilifinalproject.exception;

public class BookActiveException extends RuntimeException {
    public BookActiveException() {
        super("Book already activated bro");
    }
}
