package ge.bog.nnagliashvilifinalproject.exception;

public class BookAlreadyReservedException extends RuntimeException {
    public BookAlreadyReservedException() {
        super("Book already reserved bro");
    }
}
