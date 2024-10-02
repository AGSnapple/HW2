package exceptions;

public class Unexpected_value extends Exception {
    String message;

    public Unexpected_value(String msg) {
        this.message = msg;
    }

    public Unexpected_value() {
        this("Exception: exception.Unexpected_value was caught.");
    }

    public String getMessage() {
        return message;
    }
}
