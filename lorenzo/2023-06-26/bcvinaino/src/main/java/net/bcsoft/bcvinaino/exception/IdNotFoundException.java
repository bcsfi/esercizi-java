package net.bcsoft.bcvinaino.exception;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(Throwable cause) {
        super(cause);
    }

    public IdNotFoundException(String message) {
        super(message);
    }
}
