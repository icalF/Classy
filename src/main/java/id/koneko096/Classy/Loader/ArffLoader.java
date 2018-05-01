package id.koneko096.Classy.Loader;

import id.koneko096.Classy.Data.*;
import id.koneko096.Classy.Loader.IO.InputReader;

import java.util.*;

import static id.koneko096.Classy.Util.Constants.ATTRIBUTE_SEGMENT;
import static id.koneko096.Classy.Util.Constants.DATA_SEGMENT;
import static id.koneko096.Classy.Util.Constants.DELIMITERS;

public class ArffLoader implements BaseLoader {
    private InputReader input;

    @Override
    public void loadInput(InputReader input) {
        this.input = input;
    }

    @Override
    public Header loadHeader() {
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

            attributes.put(attrName, attrCandidates);
            line = input.next();
        }

        List<String> attrTypesStr = new ArrayList<>(Collections.nCopies(attributes.size(), "NOMINAL"));
        return new Header(attributes, attrTypesStr);
    }

    private List<String> parseAttrCandidates(String attrCandidatesStr) {
        String trimmed = attrCandidatesStr.trim();
        String cleaned = trimmed.substring(1, trimmed.length()-1);
        String[] splitted = cleaned.split(DELIMITERS);
        return Arrays.asList(splitted);
    }

    @Override
    public List<Instance> loadInstances(Header header) {
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
