package id.koneko096.Classy.Data;

public class NumericAttribute extends Attribute<Double> {
    public NumericAttribute(double value, String name) {
        super(value, name);
        this.type = AttributeType.NUMERIC;
    }

    public NumericAttribute(NumericAttribute numericAttribute) {
        super(numericAttribute);
    }
}
