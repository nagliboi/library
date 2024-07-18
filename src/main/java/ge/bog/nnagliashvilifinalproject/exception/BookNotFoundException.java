package ge.bog.nnagliashvilifinalproject.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("Book not found bro");
    }
}
