package id.koneko096.Classy.Data;

import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Class instance
 *
 * @author Afrizal Fikri
 */
@Data
public class Instance implements Collection<Attribute> {
    private List<String> attributeNames;
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
        this.attributeNames = attributes.stream().map(Attribute::getName).collect(Collectors.toList());
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
        this.attributeNames = attributes.stream().map(Attribute::getName).collect(Collectors.toList());
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


    void dropFields(List<String> fieldNames) {
        Set<String> droppedNames = new HashSet<>(fieldNames);

        List<Integer> droppedIndexes = IntStream
                .range(0, attributeNames.size())
                .filter(i -> droppedNames.contains(attributeNames.get(i)))
                .boxed()
                .collect(Collectors.toList());
        List<Integer> notDroppedIndexes = IntStream
                .range(0, attributeNames.size())
                .filter(i -> !droppedNames.contains(attributeNames.get(i)))
                .boxed()
                .collect(Collectors.toList());

        // Remove from map
        droppedIndexes.forEach(i -> attributeMap.remove(attributeNames.get(i)));

        // Remove from attr list
        attributeList = notDroppedIndexes.stream().map(attributeList::get).collect(Collectors.toList());

        // Remove from name list
        attributeNames = notDroppedIndexes.stream().map(attributeNames::get).collect(Collectors.toList());
    }
}
