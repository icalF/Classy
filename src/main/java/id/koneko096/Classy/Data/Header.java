package id.koneko096.Classy.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Header {
    private Map<String, List<String>> attributeCandidates;
    private List<Class> attributeTypes;

    public Header(Map<String, List<String>> attributeCandidates, List<String> attributeTypesStr) {
        this.attributeCandidates = attributeCandidates;
        this.attributeTypes = attributeTypesStr.stream()
                .map(AttributeType::valueOf)
                .map(AttributeType::getType)
                .collect(Collectors.toList());
    }

    public Header(Header header) {
        this.attributeCandidates = new HashMap<>(header.attributeCandidates);
        this.attributeTypes = new ArrayList<>(header.attributeTypes);
    }

    public List<Class> getAttributeTypes() {
        return attributeTypes;
    }

    public Map<String, List<String>> getAttributeCandidates() {
        return attributeCandidates;
    }
}
