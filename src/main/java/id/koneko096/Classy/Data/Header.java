package id.koneko096.Classy.Data;

import java.util.List;
import java.util.stream.Collectors;

public class Header {
    private List<String> attributeNames;
    private List<Class> attributeTypes;

    public Header(List<String> attributeNames, List<String> attributeTypesStr) {
        this.attributeNames = attributeNames;
        this.attributeTypes = attributeTypesStr.stream()
                .map(AttributeType::valueOf)
                .map(AttributeType::getType)
                .collect(Collectors.toList());
    }

    public List<Class> getAttributeTypes() {
        return attributeTypes;
    }

    public List<String> getAttributeNames() {
        return attributeNames;
    }
}
