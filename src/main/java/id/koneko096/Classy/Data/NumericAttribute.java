package id.koneko096.Classy.Data;

public class NumericAttribute extends Attribute<Double> {
    public NumericAttribute(double value, String name) {
        super(value, name, AttributeType.NUMERIC);
    }

    public NumericAttribute(NumericAttribute numericAttribute) {
        super(numericAttribute);
    }
}
