package net.bcsoft.bcvinaino.exception;

public class DateNotValidException extends RuntimeException {
    public DateNotValidException(Throwable cause) {
        super(cause);
    }

    public DateNotValidException(String message) {
        super(message);
    }
}
