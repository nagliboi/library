package ge.bog.nnagliashvilifinalproject.exception;

public class BookAlreadyRefreshedException extends RuntimeException {
    public BookAlreadyRefreshedException() {
        super("book already refreshed bro");
    }
}
