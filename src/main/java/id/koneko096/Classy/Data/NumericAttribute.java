package id.koneko096.Classy.Data;

public class NumericAttribute extends Attribute<Double> {
    public NumericAttribute(double v, String name) {
        super(v, name);
        this.type = AttributeType.NUMERIC;
    }

    public NumericAttribute(NumericAttribute numericAttribute) {
        super(numericAttribute);
    }
}
