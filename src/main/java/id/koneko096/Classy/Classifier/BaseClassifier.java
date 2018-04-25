package id.koneko096.Classy.Classifier;

import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Data.InstanceSet;

/**
 * Interface classifier
 *
 * @author Afrizal Fikri
 */
public interface BaseClassifier {
    /**
     * Initialize
     */
    void init();

    /**
     * Do training by given dataset
     * Implementation depend on each class
     *
     * @param trainSet
     */
    void train(InstanceSet trainSet);

    /**
     * Do classifying by algorithm used
     *
     * @param instance
     * @return class
     */
    String classify(Instance instance);
}