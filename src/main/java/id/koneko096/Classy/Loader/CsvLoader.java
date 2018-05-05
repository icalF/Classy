package id.koneko096.Classy.Loader;

import id.koneko096.Classy.Data.AttributeType;
import id.koneko096.Classy.Data.Header;
import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Data.InstanceParser;
import id.koneko096.Classy.Loader.IO.InputReader;
import id.koneko096.Classy.Util.Constants;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CsvLoader extends BaseLoader {
    private InputReader input;

    @Override
    public void loadInput(InputReader input) {
        super.loadInput(input);
        this.input = input;
    }

    @Override
    public Header loadHeader() {
        super.loadHeader();

        String attributeNamesStr = input.next();
        String[] attributeNamesStrs = attributeNamesStr.split(Constants.COMMA);

        Map<String, List<String>> attributeNameMap = Arrays.stream(attributeNamesStrs)
                .collect(Collectors.toMap(Function.identity(), x->Collections.EMPTY_LIST));

        String attributeTypesStr = input.next();
        attributeNamesStrs = attributeTypesStr.split(Constants.COMMA);
        List<String> attributeTypeList = Arrays.asList(attributeNamesStrs);

        return Header.builder()
                .attributeNames(new ArrayList<>(attributeNameMap.keySet()))
                .attributeCandidates(attributeNameMap)
                .attributeTypes(attributeTypeList.stream()
                        .map(AttributeType::valueOf)
                        .map(AttributeType::getType)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public List<Instance> loadInstances(Header header) {
        super.loadInstances(header);

        List<String> lines = new ArrayList<>();

        do {
            String line = input.next();
            if (line == null) break;
            lines.add(line);
        } while (true);

        return InstanceParser.parse(lines, header);
    }
}
