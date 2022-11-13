package exception;

public class NotFieldOutCompletelyException extends RuntimeException{
    public NotFieldOutCompletelyException() {
    }

    public NotFieldOutCompletelyException(String message) {
        super(message);
    }
}
