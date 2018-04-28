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
    public List<String> loadHeader() {
        String header = input.next();
        String[] ar = header.split(CsvLoader.COMMA);
        return Arrays.asList(ar).subList(0, ar.length-1);
    }

    @Override
    public List<Instance> loadInstances(List<String> header) {
        List<Instance> instances = new ArrayList<>();

        do {
            String line = input.next();
            if (line == null) break;

            String[] attrs = line.split(CsvLoader.COMMA);

            String label = attrs[attrs.length-1];
            List<String> attrList = Arrays.asList(attrs).subList(0, attrs.length-1);

            List<Attribute> attributeList = IntStream.range(0, attrList.size()).boxed()
                    .map(i -> AttributeFactory.make(
                            AttributeType.NUMERIC,
                            attrList.get(i),
                            header.get(i)))
                    .collect(Collectors.toList());

            instances.add(new Instance(attributeList, label));
        } while (true);

        return instances;
    }
}
