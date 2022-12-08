package app.prog.model;

public class BadRequest extends Exception{
    public BadRequest(String message) {
        super(ExceptionType.CLIENT_EXCEPTION, message);
    }
}
