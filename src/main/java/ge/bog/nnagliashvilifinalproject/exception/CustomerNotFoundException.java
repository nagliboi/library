package ge.bog.nnagliashvilifinalproject.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super("Customer not found bro");
    }
}
