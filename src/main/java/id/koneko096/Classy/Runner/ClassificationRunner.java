package id.koneko096.Classy.Runner;

import id.koneko096.Classy.Classifier.BaseClassifier;
import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Data.InstanceSet;
import id.koneko096.Classy.Data.SplitReturnValue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClassificationRunner {

    private BaseClassifier classifier;

    /**
     * Constructor
     *
     * @param classifier
     */
    public ClassificationRunner(BaseClassifier classifier) {
        this.classifier = classifier;
    }

    /**
     * id.koneko096.Classy.Classifier getter
     *
     * @return classifier
     */
    public BaseClassifier getClassifier() {
        return classifier;
    }

    /**
     * id.koneko096.Classy.Classifier setter
     *
     * @param classifier
     */
    public void setClassifier(BaseClassifier classifier) {
        this.classifier = classifier;
    }

    /**
     * Do cross validation
     * Fold must be larger than data train size
     *
     * @param trainSet
     * @param fold
     * @return accuracy
     */
    public double crossValidate(InstanceSet trainSet, int fold) {
        SplitReturnValue splitted = trainSet.split(fold);
        return IntStream.range(0, splitted.size()).boxed()
                .collect(Collectors.averagingDouble(i -> validate(
                    splitted.getTrainSets().get(i),
                    splitted.getTestSets().get(i)
                )));
    }

    public double validate(InstanceSet instances, List<Instance> instanceList) {
        this.classifier.train(instances);
        List<String> classifiedClass = instanceList.stream()
                .map(this.classifier::classify)
                .collect(Collectors.toList());
        return IntStream.range(0, instanceList.size()).boxed()
                .collect(Collectors.averagingDouble(i ->
                        instanceList.get(i).getLabel().equals(
                                classifiedClass.get(i)) ? 1.0 : 0.0
                ));
    }
}
