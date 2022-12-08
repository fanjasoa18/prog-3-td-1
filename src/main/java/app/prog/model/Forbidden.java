package app.prog.model;

public class Forbidden extends Exception {

    public Forbidden(String message) {
        super(ExceptionType.CLIENT_EXCEPTION, message);
    }
}
