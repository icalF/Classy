package id.koneko096.Classy.Classifier;

import id.koneko096.Classy.Data.Instance;

public interface DistanceCalculator {
    double calculate(Instance a, Instance b);
}
