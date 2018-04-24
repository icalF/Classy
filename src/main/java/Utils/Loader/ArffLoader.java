package Utils.Loader;

import Data.InstanceSet;

import java.util.Vector;

public class ArffLoader implements BaseLoader {
    @Override
    public InstanceSet parseFile(String fileName) {
        return new InstanceSet(new Vector<>());
    }
}
