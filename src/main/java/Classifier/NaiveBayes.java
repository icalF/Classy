package Classifier;

import Data.Attribute;
import Data.Instance;
import Data.InstanceSet;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NaiveBayes implements BaseClassifier {

    private List<String> attrVal;
    private Map<String, Integer> attrIdx;

    public NaiveBayes() {
        this.init();
    }

    @Override
    public void init() {

    }

    @Override
    public void train(InstanceSet trainSet) {
        attrVal = trainSet.getAttributeNames().stream().map(String::new).collect(Collectors.toList());
        attrIdx = attrVal.stream().collect(Collectors.toMap(Function.identity(), ));
    }

    @Override
    public String classify(Instance instance) {
        return null;
    }

    @Override
    public double crossValidate(int fold) {
        return 0;
    }
}
