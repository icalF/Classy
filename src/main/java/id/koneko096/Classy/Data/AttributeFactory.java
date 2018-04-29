package id.koneko096.Classy.Data;

public class AttributeFactory {
    public static Attribute make(Class type, String value, String name) {
        switch (type.getName()) {
            case "java.lang.Double":
                return new NumericAttribute(Double.parseDouble(value), name);
            case "java.lang.String":
                return new StringAttribute(value, name);
            default:
                return null;
        }
    }
}
