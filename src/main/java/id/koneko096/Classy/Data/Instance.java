package id.koneko096.Classy.Data;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class instance
 *
 * @author Afrizal Fikri
 */
@EqualsAndHashCode
public class Instance implements Collection<Attribute> {
    private Map<String, Attribute> attributeMap;

    private List<Attribute> attributeList;
    private @Getter String label;

    /**
     * Constructor
     *
     * @param attributes
     */
    public Instance(List<Attribute> attributes) {
        this.attributeList = new ArrayList<>(attributes);
        this.attributeMap = attributes.stream().collect(Collectors.toMap(
                Attribute::getName,
                Function.identity()
        ));
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
        this.attributeMap = attributes.stream().collect(Collectors.toMap(
                Attribute::getName,
                Function.identity()
        ));
        this.label = label;
    }

    /**
     * Getter attribute value by attr name
     *
     * @param attributeName
     * @return attr value
     */
    public Attribute get(String attributeName) {
        return attributeMap.get(attributeName);
    }

    /**
     * Getter attribute names
     *
     * @return attr names
     */
    public List<String> getAttributeNames() {
        return attributeList.stream().map(Attribute::getName).collect(Collectors.toList());
    }


    @Override
    public int size() {
        return attributeList.size();
    }

    @Override
    public boolean isEmpty() {
        return attributeList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return attributeList.contains(o);
    }

    @Override
    public Iterator<Attribute> iterator() {
        return attributeList.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] objects) {
        return attributeList.toArray(objects);
    }

    @Override
    public boolean add(Attribute attribute) {
        attributeMap.put(attribute.getName(), attribute);
        return attributeList.add(attribute);
    }

    @Override
    public boolean remove(Object o) {
        attributeMap.remove(((Attribute)o).getName());
        return attributeList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return attributeList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Attribute> c) {
        c.forEach(a -> attributeMap.put(a.getName(), a));
        return attributeList.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        c.forEach(a -> attributeMap.remove(((Attribute<? extends Comparable<?>>)a).getName()));
        return attributeList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        //TODO
        return attributeList.retainAll(c);
    }

    @Override
    public void clear() {
        attributeMap.clear();
        attributeList.clear();
    }

    @Override
    public Stream<Attribute> stream() {
        return attributeList.stream();
    }
}
