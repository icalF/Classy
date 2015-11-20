/**
 * Abstract class classifier
 *
 * @author Afrizal Fikri
 */
abstract class Classifier {
  /**
   * Initialize
   */
  public void init() {}

  /**
   * Do training by given dataset
   * Implementation depend on each class
   * @param trainSet
   */
  public void train(InstanceSet trainSet) {}

  /**
   * Do classifying by algorithm used
   * @param  instance
   * @return class
   */
  public String classify(Instance instance) { return null; }

  /**
   * Do cross validation
   * @param  fold
   * @return accuracy
   */
  public double crossValidate(int fold) { return 0.0; }
}