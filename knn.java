import java.util.*;
import java.lang.*;
// import 

class Knn extends Classifier 
{
  InstanceSet trainSet;
  int k;

  public Knn(int k) { this.k = k; }

  public void init() {
  }

  public void train(InstanceSet trainSet) {
    this.trainSet = trainSet;
  }

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
} 