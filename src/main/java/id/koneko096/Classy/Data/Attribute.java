package id.koneko096.Classy.Data;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class attribute
 *
 * @author Afrizal Fikri
 */
@Data
@AllArgsConstructor
public class Attribute<T> {
    private T value;
    private String name;
    private AttributeType type;

    public Attribute(Attribute<T> attr) {
        value = attr.value;
        type = attr.type;
        name = attr.name;
    }
}