package id.koneko096.Classy.Loader;

import id.koneko096.Classy.Data.*;
import id.koneko096.Classy.Loader.IO.InputReader;
import id.koneko096.Classy.Util.Constants;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CsvLoader implements BaseLoader {
    private InputReader input;

    @Override
    public void loadInput(InputReader input) {
        this.input = input;
    }

    @Override
    public Header loadHeader() {
        String attributeNamesStr = input.next();
        String[] attributeNamesStrs = attributeNamesStr.split(Constants.COMMA);

        Map<String, List<String>> attributeNameMap = Arrays.stream(attributeNamesStrs)
                .collect(Collectors.toMap(Function.identity(), x->Collections.EMPTY_LIST));

        String attributeTypesStr = input.next();
        attributeNamesStrs = attributeTypesStr.split(Constants.COMMA);
        List<String> attributeTypeList = Arrays.asList(attributeNamesStrs);

        return new Header(attributeNameMap, attributeTypeList);
    }

    @Override
    public List<Instance> loadInstances(Header header) {
        List<String> lines = new ArrayList<>();

        do {
            String line = input.next();
            if (line == null) break;
            lines.add(line);
        } while (true);

        return InstanceParser.parse(lines, header);
    }
}
