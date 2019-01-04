package id.koneko096.Classy.Classifier;

import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Data.InstanceSet;
import org.slf4j.Logger;

/**
 * Interface classifier
 *
 * @author Afrizal Fikri
 */
public interface BaseClassifier {

    /**
     * Do training by given dataset
     * Implementation depend on each class
     *
     * @param trainSet
     */
    void train(InstanceSet trainSet);

    default void writeLog(Logger log, InstanceSet trainSet) {
        log.info("Training dataset {}", trainSet.getName());
    }

    /**
     * Do classifying by algorithm used
     *
     * @param instance
     * @return class
     */
    String classify(Instance instance) throws ModelEmptyException;

    String showInfo();
}