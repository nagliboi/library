package ge.bog.nnagliashvilifinalproject.exception;

public class BookNotReservedException extends RuntimeException {
    public BookNotReservedException() {
        super("Book is not reserved bro");
    }
}
