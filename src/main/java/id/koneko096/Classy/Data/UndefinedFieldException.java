package id.koneko096.Classy.Data;

public class UndefinedFieldException extends Exception {
    UndefinedFieldException(String message) {
        super(message);
    }

    UndefinedFieldException(String message, Throwable cause) {
        super(message, cause);
    }
}
