package id.koneko096.Classy.Classifier;

import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Util.DataPreparationUtil;
import id.koneko096.Classy.Util.Math;

import java.util.List;
import java.util.stream.IntStream;

public class EuclideanDistanceCalculator implements DistanceCalculator {

  private static final String EUCLIDEAN = "Euclidean";

  @Override
  public double calculate(Instance a, Instance b) {

    List<Double> la = DataPreparationUtil.convertToListOfDouble(a);
    List<Double> lb = DataPreparationUtil.convertToListOfDouble(b);

    return Math.sqrt(IntStream.range(0, la.size()).boxed()
        .mapToDouble(i -> Math.sqr(la.get(i) - lb.get(i)))
        .sum());
  }

  @Override
  public String getName() {
    return EUCLIDEAN;
  }
}
