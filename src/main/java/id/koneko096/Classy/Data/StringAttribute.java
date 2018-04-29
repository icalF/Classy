package id.koneko096.Classy.Data;

public class StringAttribute extends Attribute {
    public StringAttribute(String value, String name) {
        super(value, name, AttributeType.NOMINAL);
    }

    public StringAttribute(StringAttribute stringAttribute) {
        super(stringAttribute);
    }
}
