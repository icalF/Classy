package id.koneko096.Classy.Data;

/**
 * Class attribute
 *
 * @author Afrizal Fikri
 */
public class Attribute<T> {
    private T value;
    private AttributeType type;
    private T[] members;

    public Attribute(Attribute<T> attr) {
        value = attr.value;
        type = attr.type;
        members = attr.members.clone();
    }

    public String getStringType() {
        return type.getType().getName();
    }
}