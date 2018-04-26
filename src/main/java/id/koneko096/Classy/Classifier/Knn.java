package id.koneko096.Classy.Classifier;

import java.util.*;
import java.lang.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import id.koneko096.Classy.Data.Attribute;
import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Data.InstanceSet;
import id.koneko096.Classy.Data.NumericAttribute;

/**
 * Class Knn
 * k Nearest Neighbourhood classifier
 *
 * @author Afrizal Fikri
 */
public class Knn implements BaseClassifier {

    private InstanceSet trainSet;
    private int k;

    public Knn(int k) {
        this.k = k;
    }

    /**
     * Initialize kNN
     */
    @Override
    public void init() {
    }

    /**
     * Add new instances to saved train set before
     * Or create new if doesnt exist
     *
     * @param trainSet
     */
    @Override
    public void train(InstanceSet trainSet) {
        this.trainSet = trainSet;
    }

    /**
     * Do classifying by given train set
     *
     * @param instance
     * @return string class
     */
    @Override
    public String classify(Instance instance) {
        List<Double> dist = trainSet.stream()
                .map(i -> Knn.EuclideanDistance(i, instance))
                .collect(Collectors.toList());
        List<String> label = trainSet.stream()
                .map(Instance::getLabel)
                .collect(Collectors.toList());
        List<Integer> sortedIdx = IntStream.range(0, trainSet.size()).boxed()
                .sorted(Comparator.comparingDouble(dist::get))
                .collect(Collectors.toList());

        Map<String, Long> counter = sortedIdx.stream()
                .limit(Math.min(sortedIdx.size(), this.k))
                .map(label::get).collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        return counter.entrySet().stream().max((label1, label2)
                        -> label1.getValue() > label2.getValue() ? 1 : -1)
                .map(Map.Entry::getKey).get();
    }

    private static double Square(double x) {
        return x * x;
    }

    /**
     * EuclideanDistance of two instance
     *
     * @param a
     * @param b
     * @return integer distance
     */
    private static double EuclideanDistance(Instance a, Instance b) {
        //TODO
        List<Double> la = Knn.convertToListOfDouble(a);
        List<Double> lb = Knn.convertToListOfDouble(b);

        return Math.sqrt(IntStream.range(0, la.size()).boxed()
                .mapToDouble(i -> Knn.Square(la.get(i) - lb.get(i)))
                .sum());
    }
    private static List<Double> convertToListOfDouble(Instance x) {
        return x.stream().map(i -> (Double)i.getValue()).collect(Collectors.toList());
    }

    /**
     * HammingDistance of two instance
     *
     * @param a
     * @param b
     * @return integer distance
     */
    private static int HammingDistance(Instance a, Instance b) {
        //TODO
        List<Integer> la = convertToListOfInteger(a);
        List<Integer> lb = convertToListOfInteger(b);

        return IntStream.range(0, la.size()).boxed()
                .map(i -> !la.get(i).equals(lb.get(i)))
                .mapToInt(bl -> (bl ? 1 : 0))
                .sum();
    }
    private static List<Integer> convertToListOfInteger(Instance x) {
        return x.stream().map(Attribute::hashCode).collect(Collectors.toList());
    }
} 