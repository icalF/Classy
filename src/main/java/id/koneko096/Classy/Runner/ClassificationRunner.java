package id.koneko096.Classy.Runner;

import id.koneko096.Classy.Classifier.BaseClassifier;
import id.koneko096.Classy.Data.InstanceSet;

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
        return 0.0;
    }
}
