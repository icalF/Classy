package id.koneko096.Classy.Data;

import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class instance
 *
 * @author Afrizal Fikri
 */
@Data
public class Instance {
    private List<String> attributeNames;
    private Map<String, Attribute> attributeMap;

    private List<Attribute> attributeList;
    private String label;

    private Set<String> disabledNames;

    /**
     * Constructor
     *
     * @param attributes
     */
    public Instance(List<Attribute> attributes) {
        this.attributeList = new ArrayList<>(attributes);
        this.attributeNames = attributes.stream().map(Attribute::getName).collect(Collectors.toList());
        this.attributeMap = attributes.stream().collect(Collectors.toMap(
                Attribute::getName,
                Function.identity()
        ));
        this.disabledNames = new HashSet<>();
        this.label = null;
    }

    /**
     * Constructor
     *
     * @param attributes
     * @param label
     */
    public Instance(List<Attribute> attributes, String label) {
        this.attributeList = new ArrayList<>(attributes);
        this.attributeNames = attributes.stream().map(Attribute::getName).collect(Collectors.toList());
        this.attributeMap = attributes.stream().collect(Collectors.toMap(
                Attribute::getName,
                Function.identity()
        ));
        this.disabledNames = new HashSet<>();
        this.label = label;
    }

    /**
     * Getter attribute value by attr name
     *
     * @param attributeName
     * @return attr values
     */
    public Attribute get(String attributeName) {
        return attributeMap.get(attributeName);
    }



    public int size() {
        return attributeList.size();
    }

    public boolean isEmpty() {
        return attributeList.isEmpty();
    }


    public boolean add(Attribute attribute) {
        attributeMap.put(attribute.getName(), attribute);
        return attributeList.add(attribute);
    }

    public boolean addAll(Collection<? extends Attribute> c) {
        List<String> additionalNames = c.stream().map(a -> {
            attributeMap.put(a.getName(), a);
            return a.getName();
        }).collect(Collectors.toList());
        if (!attributeNames.addAll(additionalNames)) return false;
        return attributeList.addAll(c);
    }

    public void clear() {
        attributeMap.clear();
        attributeNames.clear();
        attributeList.clear();
        disabledNames.clear();
    }

    public Stream<Attribute> stream() {
        return attributeList.stream();
    }

    void dropFields(List<String> fieldNames) {
        List<String> filteredNames = fieldNames.stream()
            .filter(s -> s != null && !s.isEmpty())
            .collect(Collectors.toList());
        disabledNames.addAll(filteredNames);
    }
}
