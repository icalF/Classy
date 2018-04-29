package id.koneko096.Classy.Runner;

import id.koneko096.Classy.Classifier.BaseClassifier;
import id.koneko096.Classy.Classifier.ModelEmptyException;
import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Data.InstanceSet;

import java.util.List;
import java.util.stream.Collectors;

public class ClassificationUnit {
    private final BaseClassifier classifier;
    private final InstanceSet trainSet;
    private final List<Instance> testSet;

    public ClassificationUnit(BaseClassifier classifier,
                              InstanceSet trainSet,
                              List<Instance> testSet) {
        this.classifier = classifier;
        this.trainSet = trainSet;
        this.testSet = testSet;
    }

    private List<String> classify(List<Instance> instanceList) {
        return instanceList.stream()
                .map(this::classify)
                .collect(Collectors.toList());
    }

    private String classify(Instance instance) {
        try {
            return this.classifier.classify(instance);
        } catch (ModelEmptyException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> run() {
        if (this.trainSet != null)
            this.classifier.train(this.trainSet);

        return this.classify(this.testSet);
    }
}
