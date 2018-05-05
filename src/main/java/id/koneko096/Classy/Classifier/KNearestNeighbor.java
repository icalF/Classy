package id.koneko096.Classy.Classifier;

import java.util.*;
import java.lang.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Data.InstanceSet;
import id.koneko096.Classy.Util.DistanceCalculator;

/**
 * Class KNearestNeighbor
 * k Nearest Neighbourhood classifier
 *
 * @author Afrizal Fikri
 */
public class KNearestNeighbor extends BaseClassifier {

    private InstanceSet trainSet;
    private int k;

    public KNearestNeighbor(int k) {
        this.k = k;
    }

    /**
     * Add new instances to saved train set before
     * Or create new if doesnt exist
     *
     * @param trainSet
     */
    @Override
    public void train(InstanceSet trainSet) {
        super.train(trainSet);
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
                .map(i -> DistanceCalculator.EuclideanDistance(i, instance))
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
                .map(Map.Entry::getKey).orElse(null);
    }

    @Override
    public String showInfo() {
        return "Classifier: K Nearest Neighbors\n" +
                "Neighbor number: " +
                this.k +
                "\nDistance metric: Euclidean distance\n";
    }
}