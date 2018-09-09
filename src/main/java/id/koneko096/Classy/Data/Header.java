package id.koneko096.Classy.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@Builder
public class Header {
    private List<String> attributeNames;
    private Map<String, List<String>> attributeCandidates;
    private List<Class> attributeTypes;

    public Header(Header header) {
        this.attributeNames = new ArrayList<>(header.attributeNames);
        this.attributeCandidates = new HashMap<>(header.attributeCandidates);
        this.attributeTypes = new ArrayList<>(header.attributeTypes);
    }
}
