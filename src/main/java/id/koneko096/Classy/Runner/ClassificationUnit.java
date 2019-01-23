package id.koneko096.Classy.Runner;

import id.koneko096.Classy.Classifier.BaseClassifier;
import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Data.InstanceSet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@Builder
class ClassificationUnit {
    private final BaseClassifier classifier;
    private final InstanceSet trainSet;
    private final List<Instance> testSet;

    private List<String> classify(List<Instance> instanceList) {
        return instanceList.stream()
                .map(this::classify)
                .collect(Collectors.toList());
    }

    private String classify(Instance instance) {
        return this.classifier.classify(instance);
    }

    List<String> run() {
        if (this.trainSet != null)
            this.classifier.train(this.trainSet);

        return this.classify(this.testSet);
    }
}
