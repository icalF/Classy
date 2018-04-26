package id.koneko096.Classy.Classifier;

import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Data.InstanceSet;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NaiveBayes implements BaseClassifier {

    private List<String> attrVal;
    private Map<String, Integer> attrIdx;

    private List<String> classVal;
    private Map<String, Integer> classIdx;

    public NaiveBayes() {
        this.init();
    }

    @Override
    public void init() {

    }

    @Override
    public void train(InstanceSet trainSet) {
        prepareTable(trainSet);
    }

    private void prepareTable(InstanceSet trainSet) {
        attrVal = trainSet.getAttributeNames().stream()
                .map(String::new)
                .collect(Collectors.toList());
        attrIdx = IntStream.range(0, attrVal.size()).boxed()
                .collect(Collectors.toMap(attrVal::get, Function.identity()));

//        classVal = trainSet.getLabels().stream()
//                .distinct().map(String::new)
//                .collect(Collectors.toList());
//        classIdx = IntStream.range(0, classVal.size()).boxed()
//                .collect(Collectors.toMap(classVal::get, Function.identity()));
    }

    @Override
    public String classify(Instance instance) {
        return null;
    }
}
