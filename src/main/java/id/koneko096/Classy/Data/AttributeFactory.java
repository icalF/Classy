package id.koneko096.Classy.Data;

public class AttributeFactory {
    public Attribute makeAttribute(String type, String value) {
        switch (type) {
            case "numeric":
                return new NumericAttribute(Double.parseDouble(value));
            default:
                return null;
        }
    }
}
