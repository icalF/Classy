package id.koneko096.Classy.Classifier;

import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Util.DataPreparationUtil;

import java.util.List;
import java.util.stream.IntStream;

public class HammingDistanceCalculator implements DistanceCalculator {
  @Override
  public double calculate(Instance a, Instance b) {
    List<Integer> la = DataPreparationUtil.convertToListOfInteger(a);
    List<Integer> lb = DataPreparationUtil.convertToListOfInteger(b);

    return IntStream.range(0, la.size()).boxed()
        .map(i -> !la.get(i).equals(lb.get(i)))
        .mapToInt(bl -> (bl ? 1 : 0))
        .sum();
  }
}
