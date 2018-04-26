package id.koneko096.Classy.Data;

import java.util.*;
import java.lang.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class instance
 *
 * @author Afrizal Fikri
 */
public class Instance implements Collection<Attribute> {
    private Map<String, Attribute> attributeMap;

    private List<Attribute> attributeList;
    private String label;

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

    /**
     * Set the class label of current instance
     *
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Set the class label of current instance
     *
     * @return label
     */
    public String getLabel() {
        return this.label;
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
        attributeMap.put(attribute.getStringType(), attribute);
        return attributeList.add(attribute);
    }

    @Override
    public boolean remove(Object o) {
        attributeMap.remove(((Attribute)o).getStringType());
        return attributeList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return attributeList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Attribute> c) {
        c.forEach(a -> attributeMap.put(a.getStringType(), a));
        return attributeList.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        c.forEach(a -> attributeMap.remove(((Attribute<Object>)a).getStringType()));
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
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Instance)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Instance i = (Instance) o;

        // Compare the data members and return accordingly
        List<Attribute> il = i.attributeList.stream().sorted().collect(Collectors.toList());
        List<Attribute> sl = this.attributeList.stream().sorted().collect(Collectors.toList());
        return il.equals(sl);
    }

    @Override
    public Stream<Attribute> stream() {
        return attributeList.stream();
    }
}
