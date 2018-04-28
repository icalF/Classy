package id.koneko096.Classy.Data;

import id.koneko096.Classy.Loader.BaseLoader;

import java.util.List;

public class InstanceSetFactory {
    public static InstanceSet make(BaseLoader loader) {
        List<String> attributeNames = loader.loadHeader();
        List<Instance> instances = loader.loadInstances(attributeNames);
        return new InstanceSet(instances);
    }
}
