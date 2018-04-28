package id.koneko096.Classy.Data;

import java.util.List;

public class CrossSplit {
    private final List<InstanceSet> trainSets;
    private final List<List<Instance>> testSets;
    private final int _size;

    public CrossSplit(List<InstanceSet> trainSets, List<List<Instance>> testSets) {
        this.trainSets = trainSets;
        this.testSets = testSets;
        this._size = trainSets.size();
    }

    public List<InstanceSet> getTrainSets() {
        return trainSets;
    }

    public List<List<Instance>> getTestSets() {
        return testSets;
    }

    public int size() {
        return this._size;
    }
}
