package id.koneko096.Classy.Data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CrossSplit {
    private final List<InstanceSet> trainSets;
    private final List<List<Instance>> testSets;

    public int size() {
        return this.trainSets.size();
    }
}
