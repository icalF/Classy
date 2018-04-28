package id.koneko096.Classy.Classifier;

import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Data.InstanceSet;

/**
 * Interface classifier
 *
 * @author Afrizal Fikri
 */
public abstract class BaseClassifier implements Cloneable {
    /**
     * Initialize
     */
    abstract public void init();

    /**
     * Do training by given dataset
     * Implementation depend on each class
     *
     * @param trainSet
     */
    abstract public void train(InstanceSet trainSet);

    /**
     * Do classifying by algorithm used
     *
     * @param instance
     * @return class
     */
    abstract public String classify(Instance instance) throws ModelEmptyException;

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