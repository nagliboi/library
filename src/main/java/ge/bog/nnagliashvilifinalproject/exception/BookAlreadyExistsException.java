package ge.bog.nnagliashvilifinalproject.exception;

public class BookAlreadyExistsException extends RuntimeException {

    public BookAlreadyExistsException() {
        super("Book with that title already exists bro");
    }
}
