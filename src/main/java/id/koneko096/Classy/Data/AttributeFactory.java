package id.koneko096.Classy.Data;

public class AttributeFactory {
    public static Attribute makeAttribute(AttributeType type, String value, String name) {
        switch (type.getType().getName()) {
            case "java.lang.Double":
                return new NumericAttribute(Double.parseDouble(value), name);
            default:
                return null;
        }
    }
}
