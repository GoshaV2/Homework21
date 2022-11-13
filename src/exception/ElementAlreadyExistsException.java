package exception;

public class ElementAlreadyExistsException extends RuntimeException{
    public ElementAlreadyExistsException() {
    }

    public ElementAlreadyExistsException(String message) {
        super(message);
    }
}
