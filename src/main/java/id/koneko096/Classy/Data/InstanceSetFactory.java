package id.koneko096.Classy.Data;

import id.koneko096.Classy.Loader.BaseLoader;

import java.util.List;

public class InstanceSetFactory {

    private InstanceSetFactory() {

    }

    public static InstanceSet make(BaseLoader loader, String name) {
        Header header = loader.parseHeader();
        List<Instance> instances = loader.parseInstances(header);
        return InstanceSet.builder()
                .instanceList(instances)
                .header(header)
                .name(name)
                .build();
    }
}
