package Classifier;

import Data.Instance;
import Data.InstanceSet;

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

    /**
     * Do cross validation
     *
     * @param fold
     * @return accuracy
     */
    double crossValidate(int fold);
}