import java.util.*;
import java.lang.*;

/**
 * Class Knn
 * k Nearest Neighbourhood classifier
 *
 * @author Afrizal Fikri
 */
class Knn extends Classifier 
{
  InstanceSet trainSet;
  int k;

  public Knn(int k) { this.k = k; }

  /**
   * Initialize kNN
   */
  public void init() {
  }

  /**
   * Add new instances to saved train set before
   * Or create new if doesnt exist
   * @param trainSet
   */
  public void train(InstanceSet trainSet) {
    if (trainSet == null) {
      this.trainSet = trainSet;
    } else {
      for(int i = 0; i < trainSet.size(); ++i)
        this.trainSet.add(trainSet.get(i));
    }
  }

  /**
   * Do classifying by given train set
   * @param  instance
   * @return string class
   */
  public String classify(Instance instance) {
    Vector<Integer> dist = new Vector<>();
    Vector<String> label = new Vector<>();
    Vector<Integer> idx = new Vector<>();
    Map<String, Integer> counter = new TreeMap<>();

    for (int i = 0; i < trainSet.size(); ++i) {
      dist.add(HammingDistance(trainSet.get(i), instance));
      label.add(trainSet.get(i).getLabel());
      idx.add(i);
    }
    Collections.sort(idx, (o1,o2) -> Integer.compare(dist.get(o1), dist.get(o2)));

    for (int i = 0; i < Math.min(k, idx.size()); ++i) {
      int idxx = idx.get(i);
      Integer num = counter.get(label.get(idxx));

      if (num == null)
        num = 0;
      counter.put(label.get(idxx), ++num);
    }

    return Collections.max(counter.entrySet(), 
                            (label1, label2) -> label1.getValue() > label2.getValue() ? 1 : -1
                          ).getKey();
  }

  /**
   * HammingDistance of two instance
   * @param  a
   * @param  b
   * @return integer distance
   */
  public int HammingDistance(Instance a, Instance b) {
    Vector<Comparable> l1, l2;
    l1 = a.getList();
    l2 = b.getList();

    assert(l1.size() == l2.size());       // # of instance attributes must be equal

    int n = l1.size();
    int dist = 0;

    for (int i = 0; i < n; ++i)
      if (!l1.get(i).equals(l2.get(i)))
        dist++;

    return dist;
  }

  /**
   * Do cross validation
   * Fold must be larger than data train size
   * @param  fold
   * @return accuracy
   */
  public double crossValidate(int fold) {
    int n = trainSet.size();
    Vector<Instance> list = trainSet.getList();
    InstanceSet asli = trainSet;
    double maxi = n;
    int d = n / fold;

    for (int l = 0, r = d; l < n; l += d, r += d) 
    {
      InstanceSet tempSet = new InstanceSet(trainSet.getAttributes());

      for(int i = 0; i < n; ++i) {
        if (i >= l && i < r) continue;
        tempSet.add(trainSet.get(i));
      }

      trainSet = tempSet;
      int counter = 0;
      for(int i = l; i < r; ++i) {
        Instance cur = asli.get(i);
        if (classify(cur) != cur.getLabel()) counter++;
      }

      if (counter < maxi) maxi = counter;
    }

    trainSet = asli;
    return maxi / d;
  }
} 