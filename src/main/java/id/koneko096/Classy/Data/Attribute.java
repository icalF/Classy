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
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Attribute)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Attribute a = (Attribute) o;

        // Compare the data members and return accordingly
        return name.equals(a.name) && type.equals(a.type) && value.equals(a.value);
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