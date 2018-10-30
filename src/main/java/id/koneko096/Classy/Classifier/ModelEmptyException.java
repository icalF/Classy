package id.koneko096.Classy.Classifier;

public class ModelEmptyException extends RuntimeException {

    public ModelEmptyException(String s) {
        super(s);
    }

    public ModelEmptyException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
