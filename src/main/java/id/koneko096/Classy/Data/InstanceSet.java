package id.koneko096.Classy.Data;

import java.util.*;
import java.lang.*;

/**
 * Class instance-set
 *
 * @author Afrizal Fikri
 */
public class InstanceSet implements Collection<Instance>, Cloneable, RandomAccess {
    private List<Instance> instanceList;
    private List<String> attributeNames;
    private List<String> labels;

    /**
     * Constructor
     *
     * @param attributeNames
     * @param labels
     */
    public InstanceSet(List<String> attributeNames, List<String> labels) {
        this.attributeNames = new ArrayList<>(attributeNames);
        this.instanceList = new ArrayList<>();
        this.labels = new ArrayList<>(labels);
    }

    /**
     * Copy cnstructor
     *
     * @param is
     */
    public InstanceSet(InstanceSet is) {
        this.attributeNames = new ArrayList<>(is.attributeNames);
        this.instanceList = new ArrayList<>(is.instanceList);
        this.labels = new ArrayList<>(is.labels);
    }

    /**
     * Get list attribute names
     *
     * @return attribute names
     */
    public List<String> getAttributeNames() {
        return attributeNames;
    }

    /**
     * Get all labels possible
     *
     * @return list labels
     */
    public List<String> getLabels() {
        return labels;
    }



    @Override
    public int size() {
        return instanceList.size();
    }

    @Override
    public boolean isEmpty() {
        return instanceList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return instanceList.contains(o);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Instance o) {
        return instanceList.add(o);
    }

    @Override
    public boolean remove(Object o) {
        return instanceList.remove(o);
    }

    @Override
    public boolean addAll(Collection<? extends Instance> collection) {
        return instanceList.addAll(collection);
    }

    @Override
    public void clear() {
        instanceList.clear();
    }

    @Override
    public boolean retainAll(Collection collection) {
        return instanceList.retainAll(collection);
    }

    @Override
    public boolean removeAll(Collection collection) {
        return instanceList.removeAll(collection);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return instanceList.containsAll(collection);
    }

    @Override
    public <T> T[] toArray(T[] objects) {
        return instanceList.toArray(objects);
    }

    @Override
    public Iterator<Instance> iterator() {
        return instanceList.iterator();
    }
}