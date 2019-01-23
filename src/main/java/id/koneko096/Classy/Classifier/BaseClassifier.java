package id.koneko096.Classy.Classifier;

import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Data.InstanceSet;
import id.koneko096.Classy.Util.Constants;
import id.koneko096.Classy.Util.Loggable;
import org.slf4j.Logger;

/**
 * Interface classifier
 *
 * @author Afrizal Fikri
 */
public interface BaseClassifier extends Loggable {

  /**
     * Do training by given dataset
     * Implementation depend on each class
     *
     * @param trainSet
     */
    void train(InstanceSet trainSet);

    default void writeLog(Logger log, String trainSetName) {
        writeLog(log, Constants.LOG_TRAINING_DATASET, trainSetName);
    }

    /**
     * Do classifying by algorithm used
     *
     * @param instance
     * @return class
     */
    String classify(Instance instance);

    String showInfo();
}