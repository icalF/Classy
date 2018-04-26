package id.koneko096.Classy.Loader;

import id.koneko096.Classy.Data.InstanceSet;

import java.util.ArrayList;

public class ArffLoader implements BaseLoader {
    @Override
    public InstanceSet parseFile(String fileName) {
        return new InstanceSet(new ArrayList<>());
    }
}
