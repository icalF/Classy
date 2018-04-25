package id.koneko096.Classy.Data;

/**
 * Class attribute
 *
 * @author Afrizal Fikri
 */
public class Attribute<T> {
    private T value;
    protected AttributeType type;

    public Attribute(T value) {
        this.value = value;
    }

    public Attribute(Attribute<T> attr) {
        value = attr.value;
        type = attr.type;
    }

    public String getStringType() {
        return type.getType().getName();
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}