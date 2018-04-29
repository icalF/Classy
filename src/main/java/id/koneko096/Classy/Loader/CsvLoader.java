package id.koneko096.Classy.Loader;

import id.koneko096.Classy.Data.*;
import id.koneko096.Classy.Loader.IO.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CsvLoader implements BaseLoader {
    private final static String COMMA = ",";
    private InputReader input;

    @Override
    public void loadInput(InputReader input) {
        this.input = input;
    }

    @Override
    public Header loadHeader() {
        String attributeNamesStr = input.next();
        String[] x = attributeNamesStr.split(CsvLoader.COMMA);
        //TODO: NAMING
        List<String> ar = Arrays.asList(x);

        String attributeTypesStr = input.next();
        x = attributeTypesStr.split(CsvLoader.COMMA);
        List<String> ax = Arrays.asList(x);

        return new Header(ar, ax);
    }

    @Override
    public List<Instance> loadInstances(Header header) {
        List<Instance> instances = new ArrayList<>();
        List<String> attrNames = header.getAttributeNames();
        List<Class> attrTypes = header.getAttributeTypes();

        do {
            String line = input.next();
            if (line == null) break;

            String[] attrs = line.split(CsvLoader.COMMA);

            String label = attrs[attrs.length-1];
            List<String> attrList = Arrays.asList(attrs).subList(0, attrs.length-1);

            List<Attribute> attributeList = IntStream.range(0, attrList.size()).boxed()
                    .map(i -> AttributeFactory.make(
                            attrTypes.get(i),
                            attrList.get(i),
                            attrNames.get(i)))
                    .collect(Collectors.toList());

            instances.add(new Instance(attributeList, label));
        } while (true);

        return instances;
    }
}
