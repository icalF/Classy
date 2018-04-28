package id.koneko096.Classy.Util;

import id.koneko096.Classy.Data.Attribute;
import id.koneko096.Classy.Data.Instance;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DistanceCalculator {
    /**
     * EuclideanDistance of two instance
     *
     * @param a
     * @param b
     * @return integer distance
     */
    public static double EuclideanDistance(Instance a, Instance b) {
        //TODO
        List<Double> la = convertToListOfDouble(a);
        List<Double> lb = convertToListOfDouble(b);

        return Math.sqrt(IntStream.range(0, la.size()).boxed()
                .mapToDouble(i -> Math.sqr(la.get(i) - lb.get(i)))
                .sum());
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


    private static List<Double> convertToListOfDouble(Instance x) {
        return x.stream().map(i -> (Double)i.getValue()).collect(Collectors.toList());
    }

    private static List<Integer> convertToListOfInteger(Instance x) {
        return x.stream().map(Attribute::hashCode).collect(Collectors.toList());
    }
}
