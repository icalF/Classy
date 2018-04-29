package id.koneko096.Classy.Data;

import id.koneko096.Classy.Loader.BaseLoader;

import java.util.List;

public class InstanceSetFactory {
    public static InstanceSet make(BaseLoader loader) {
        Header header = loader.loadHeader();
        List<String> attributeNames = header.getAttributeNames();
        List<Class> attributeTypes = header.getAttributeTypes();
        List<Instance> instances = loader.loadInstances(header);
        return new InstanceSet(instances);
    }
}
