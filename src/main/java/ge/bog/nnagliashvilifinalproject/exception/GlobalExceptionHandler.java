package ge.bog.nnagliashvilifinalproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookAlreadyExistsException.class)
    public ResponseEntity<?> handleBookAlreadyExistsException(BookAlreadyExistsException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?> handleBookNotFoundException(BookNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotActiveException.class)
    public ResponseEntity<?> handleBookNotActiveException(BookNotActiveException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BookActiveException.class)
    public ResponseEntity<?> handleBookActiveException(BookActiveException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({CustomerNotFoundException.class})
    public ResponseEntity<?> handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({BookNotLeftException.class})
    public ResponseEntity<?> handleBookNotLeftException(BookNotLeftException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({BookNotReservedException.class})
    public ResponseEntity<?> handleBookNotReservedException(BookNotReservedException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({BookAlreadyReservedException.class})
    public ResponseEntity<?> handleBookAlreadyReservedException(BookAlreadyReservedException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({BookNotReturnedException.class})
    public ResponseEntity<?> handleBookNotReturnedException(BookNotReturnedException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({RatingOutOfRangeException.class})
    public ResponseEntity<?> handleRatingOutOfRangeException(RatingOutOfRangeException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }


    @ExceptionHandler({BookAlreadyRefreshedException.class})
    public ResponseEntity<?> handleBookAlreadyRefreshedException(BookAlreadyRefreshedException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({BookAlreadyReturnedException.class})
    public ResponseEntity<?> handleBookAlreadyRefreshedException(BookAlreadyReturnedException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }






}
