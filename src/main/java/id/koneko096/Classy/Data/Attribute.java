package id.koneko096.Classy.Data;

/**
 * Class attribute
 *
 * @author Afrizal Fikri
 */
public class Attribute<T> implements Comparable<Attribute<T>> {
    private T value;

    private String name;
    protected AttributeType type;

    public Attribute(T value, String name) {
        this.value = value;
        this.name = name;
    }

    public Attribute(Attribute<T> attr) {
        value = attr.value;
        type = attr.type;
        name = attr.name;
    }

    public String getName() {
        return this.name;
    }

    public String getStringType() {
        return type.getType().getName();
    }

    public T getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public int compareTo(Attribute<T> o) {
        return Integer.compare(hashCode(), o.hashCode());
    }
}