package ge.bog.nnagliashvilifinalproject.exception;

public class BookNotLeftException extends RuntimeException {
    public BookNotLeftException() {
        super("Book not left in the store bro");
    }
}
