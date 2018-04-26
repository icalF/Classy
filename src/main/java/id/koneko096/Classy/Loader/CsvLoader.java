package id.koneko096.Classy.Loader;

import id.koneko096.Classy.Data.*;
import id.koneko096.Classy.Loader.IO.FileInputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CsvLoader implements BaseLoader {
    private final static String COMMA = ",";

    @Override
    public InstanceSet parseFile(String fileName) {
        FileInputReader in = new FileInputReader(fileName);

        String header = in.next();
        String[] ar = header.split(CsvLoader.COMMA);
        List<String> attributeNames = Arrays.asList(ar).subList(0, ar.length-1);

        List<Instance> instances = new ArrayList<>();

        do {
            String line = in.next();
            if (line == null) break;

            String[] attrs = line.split(CsvLoader.COMMA);

            String label = attrs[attrs.length-1];
            List<String> attrList = Arrays.asList(attrs).subList(0, attrs.length-1);

            instances.add(new Instance(IntStream.range(0, attrList.size()).boxed()
                                        .map(i -> AttributeFactory.makeAttribute(
                                                AttributeType.NUMERIC,
                                                attrList.get(i),
                                                attributeNames.get(i)))
                                        .collect(Collectors.toList()),
                                       label));
        } while (true);

        return new InstanceSet(instances);
    }
}
