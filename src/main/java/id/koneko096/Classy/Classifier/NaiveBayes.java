package id.koneko096.Classy.Classifier;

import id.koneko096.Classy.Data.Attribute;
import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Data.InstanceSet;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NaiveBayes extends BaseClassifier {

    private List<Map<Attribute, Integer>> attrValIdx;

    private Map<String, Integer> classIdx;

    private int[][][] table;
    private int[] classCum;
    private int[][] attrCum;

    public NaiveBayes() {

    }

    @Override
    public void train(InstanceSet trainSet) {
        prepareTable(trainSet);
        fillTable(trainSet);
        int x = 1;
    }

    private void fillTable(InstanceSet trainSet) {
        trainSet.stream().forEach(instance -> {
            String label = instance.getLabel();
            List<String> attrNames = instance.getAttributeNames();
            int classId = this.classIdx.get(label);

            IntStream.range(0, attrNames.size()).forEach(id -> {
                    String attrName = attrNames.get(id);
                    Attribute attr = instance.get(attrName);
                    int attrIdx = this.attrValIdx.get(id).get(attr);

                    this.table[id][attrIdx][classId]++;
                    this.attrCum[id][attrIdx]++;
            });
            this.classCum[classId]++;
        });

    }

    private void prepareTable(InstanceSet trainSet) {
        int attrSz = trainSet.getAttributeNames().size();
        List<List<Attribute>> attrVal = IntStream.range(0, attrSz).boxed()
                .map(i -> {
                    String attrName = trainSet.getAttributeNames().get(i);
                    return trainSet.stream().map(instance -> instance.get(attrName))
                            .sorted().distinct()
                            .collect(Collectors.toList());
                }).collect(Collectors.toList());
        this.attrValIdx = attrVal.stream()
                .map(av -> IntStream.range(0, av.size()).boxed()
                         .collect(Collectors.toMap(av::get, Function.identity())))
                .collect(Collectors.toList());

        List<String> classVal = trainSet.stream()
                .map(Instance::getLabel)
                .sorted().distinct()
                .collect(Collectors.toList());
        this.classIdx = IntStream.range(0, classVal.size()).boxed()
                .collect(Collectors.toMap(classVal::get, Function.identity()));

        int maxSize = attrVal.stream().map(List::size).max(Integer::compareTo).orElse(0);

        this.table = new int[attrVal.size()][maxSize][classVal.size()];
        this.attrCum = new int[attrVal.size()][maxSize];
        this.classCum = new int [classVal.size()];
    }

    @Override
    public String classify(Instance instance) {
        return null;
    }
}
