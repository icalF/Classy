package id.koneko096.Classy.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class instance-set
 *
 * @author Afrizal Fikri
 */
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class InstanceSet implements Collection<Instance> {
    private List<Instance> instanceList;
    private Header header;
    @Getter private String name;

    /**
     * Copy cnstructor
     *
     * @param is
     */
    public InstanceSet(InstanceSet is) {
        this.instanceList = new ArrayList<>(is.instanceList);
        this.header = new Header(header);
    }

    /**
     * Split instances into number of folds
     *
     * @return split wrapper
     */
    public CrossSplit split(int fold) {
        List<Instance> shuffled = new ArrayList<>(this.instanceList);
        Collections.shuffle(shuffled);

        Map<Integer, List<Instance>> groupedId = IntStream.range(0, shuffled.size())
                .boxed()
                .collect(Collectors.groupingBy(i -> i % fold,
                        Collectors.mapping(shuffled::get, Collectors.toList())));

        List<List<Instance>> testSets = IntStream.range(0, fold).boxed()
                .map(groupedId::get)
                .collect(Collectors.toList());
        List<InstanceSet> trainSets = IntStream.range(0, fold).boxed()
                .map(i -> {
                    List<Instance> l = IntStream.range(0, fold).boxed()
                            .filter(j -> !j.equals(i))
                            .map(testSets::get)
                            .flatMap(List::stream)
                            .collect(Collectors.toList());
                    return InstanceSet.builder()
                            .header(this.header)
                            .instanceList(l)
                            .name(this.name + " - fold " + i)
                            .build();
                })
                .collect(Collectors.toList());

        return new CrossSplit(trainSets, testSets);
    }


    public List<String> getAttributeNames() {
        return header.getAttributeNames();
    }

    public Map<String, List<String>> getAttributeCandidates() {
        return header.getAttributeCandidates();
    }

    public List<Class> getAttributeTypes() {
        return header.getAttributeTypes();
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