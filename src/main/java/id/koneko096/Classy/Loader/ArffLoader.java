package id.koneko096.Classy.Loader;

import id.koneko096.Classy.Data.AttributeType;
import id.koneko096.Classy.Data.Header;
import id.koneko096.Classy.Data.Instance;
import id.koneko096.Classy.Data.InstanceParser;
import id.koneko096.Classy.Loader.IO.InputReader;

import java.util.*;
import java.util.stream.Collectors;

import static id.koneko096.Classy.Util.Constants.*;

public class ArffLoader extends BaseLoader {
    private InputReader input;

    @Override
    public void loadInput(InputReader input) {
        super.loadInput(input);
        this.input = input;
    }

    @Override
    public Header loadHeader() {
        super.loadHeader();

        List<String> attrNames = new ArrayList<>();
        Map<String, List<String>> attributes = new HashMap<>();

        String line = input.next();
        while (line != null && !line.startsWith(ATTRIBUTE_SEGMENT)) {
            line = input.next();
        }

        while (line != null && line.startsWith(ATTRIBUTE_SEGMENT)) {
            String attribute = line.substring(line.indexOf(ATTRIBUTE_SEGMENT) + ATTRIBUTE_SEGMENT.length() + 1);

            int firstSpacePos = attribute.indexOf(' ');
            String attrName = attribute.substring(0, firstSpacePos);

            String attrCandidatesStr = attribute.substring(firstSpacePos + 1);
            List<String> attrCandidates = parseAttrCandidates(attrCandidatesStr);

            if (!attrName.equals("class")) {
                attributes.put(attrName, attrCandidates);
                attrNames.add(attrName);
            }

            line = input.next();
        }

        List<String> attrTypesStr = new ArrayList<>(Collections.nCopies(attributes.size(), "NOMINAL")); //  TODO: READ FROM FILE/CONFIG
        return Header.builder()
                .attributeNames(attrNames)
                .attributeNameSet(new HashSet<>(attrNames))
                .attributeCandidates(attributes)
                .attributeTypes(attrTypesStr.stream()
                        .map(AttributeType::valueOf)
                        .map(AttributeType::getType)
                        .collect(Collectors.toList()))
                .build();
    }

    private List<String> parseAttrCandidates(String attrCandidatesStr) {
        String trimmed = attrCandidatesStr.trim();
        String cleaned = trimmed.substring(1, trimmed.length()-1);
        String[] splitted = cleaned.split(DELIMITERS);
        return Arrays.stream(splitted).filter(s -> s != null && !s.isEmpty()).collect(Collectors.toList());
    }

    @Override
    public List<Instance> loadInstances(Header header) {
        super.loadInstances(header);

        String line = input.next();
        while (line != null && !line.startsWith(DATA_SEGMENT)) {
            line = input.next();
        }
        line = input.next();

        if (line == null) {
            return Collections.EMPTY_LIST;
        }

        List<String> lines = new ArrayList<>();
        do {
            lines.add(line);
            line = input.next();
        } while (line != null);

        return InstanceParser.parse(lines, header);
    }

}
