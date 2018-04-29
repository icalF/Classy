package id.koneko096.Classy.Runner;

import id.koneko096.Classy.Classifier.BaseClassifier;
import id.koneko096.Classy.Data.CrossSplit;
import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Data.InstanceSet;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter @Setter
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

    public void train(InstanceSet trainSet) {
        this.classifier.train(trainSet);
    }

    public String classify(Instance instance) {
        return new ClassificationUnit.ClassificationUnitBuilder()
                .classifier(this.classifier)
                .trainSet(null)
                .testSet(Collections.singletonList(instance))
                .build()
                .run()
                .get(0);
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
        CrossSplit splitted = trainSet.split(fold);
        List<InstanceSet> trainSets = splitted.getTrainSets();
        List<List<Instance>> testSets = splitted.getTestSets();

        List<ClassificationUnit> clfList = IntStream.range(0, fold).boxed()
                .map(i -> new ClassificationUnit.ClassificationUnitBuilder()
                        .classifier((BaseClassifier)(this.classifier.clone()))
                        .trainSet(trainSets.get(i))
                        .testSet(testSets.get(i))
                        .build())
                .collect(Collectors.toList());

        List<List<String>> expectedClasses = testSets.stream()
                .map(instances -> instances.stream()
                        .map(Instance::getLabel)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        List<List<String>> actualClasses = clfList.stream()
                .map(ClassificationUnit::run)
                .collect(Collectors.toList());

        return IntStream.range(0, splitted.size()).boxed()
                .collect(Collectors.averagingDouble(i -> validate(
                    expectedClasses.get(i),
                    actualClasses.get(i)
                )));
    }

    private double validate(List<String> expecteds, List<String> actuals) {
        return IntStream.range(0, expecteds.size()).boxed()
                    .collect(Collectors.averagingDouble(i ->
                        expecteds.get(i).equals(actuals.get(i)) ? 1.0 : 0.0 ));
    }
}
