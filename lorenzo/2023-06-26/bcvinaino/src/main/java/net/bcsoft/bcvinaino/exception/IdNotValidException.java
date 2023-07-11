package net.bcsoft.bcvinaino.exception;

public class IdNotValidException extends RuntimeException {
    public IdNotValidException(Throwable cause) {
        super(cause);
    }

    public IdNotValidException(String message) {
        super(message);
    }
}
