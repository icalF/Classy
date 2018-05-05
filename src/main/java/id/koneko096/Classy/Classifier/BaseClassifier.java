package id.koneko096.Classy.Classifier;

import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Data.InstanceSet;
import lombok.extern.slf4j.Slf4j;

/**
 * Interface classifier
 *
 * @author Afrizal Fikri
 */
@Slf4j
public abstract class BaseClassifier implements Cloneable {

    /**
     * Do training by given dataset
     * Implementation depend on each class
     *
     * @param trainSet
     */
    public void train(InstanceSet trainSet) {
      log.info("Training dataset {}", trainSet.getName());
    }

    /**
     * Do classifying by algorithm used
     *
     * @param instance
     * @return class
     */
    abstract public String classify(Instance instance) throws ModelEmptyException;

    abstract public String showInfo();

    public Object clone() {
        BaseClassifier octClone;

        try {
            octClone = (BaseClassifier) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            octClone = null;
        }

        return octClone;
    }
}