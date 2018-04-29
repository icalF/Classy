package id.koneko096.Classy.Data;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Class attribute
 *
 * @author Afrizal Fikri
 */
@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class Attribute<T> implements Comparable<Attribute<T>> {
    private T value;
    private String name;
    private AttributeType type;

    public Attribute(Attribute<T> attr) {
        value = attr.value;
        type = attr.type;
        name = attr.name;
    }

    @Override
    public int compareTo(Attribute<T> o) {
        return Integer.compare(hashCode(), o.hashCode());
    }
}