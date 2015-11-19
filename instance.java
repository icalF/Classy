import java.util.*;
import java.lang.*;

class Instance {
  private Vector<Object> instanceAttributes;
  private Map<String, Integer> attributeIndices;
  private String label;

  public Instance(Vector<String> attributeNames) {
    attributeIndices = new HashMap<String, Integer>();
    instanceAttributes = new Vector<Object>(attributeNames.size());
    
    int counter = 0;
    for (String s : attributeNames) {
      attributeIndices.put(s, counter++);
    }
  }

  public Object get(String attributeName) {
    return instanceAttributes.get(attributeIndices(attributeName));
  }

  public void add(Object attrVal) {
    instanceAttributes.add(attrVal);
  }

  public void setLabel(String label) { this.label = label; }

  public String getLabel { return this.label; }
}

class InstanceSet {
  private Vector<Instance> instanceList;
  private Vector<String> attributeNames;
  private Map<String, Vector<String>> nomina;

  public InstanceSet(Vector<String> attributeNames) {
    this.attributeNames = attributeNames;
    instanceList = new Vector<Instance>(attributeNames.size());
    nomina = new HashMap<String, Vector<>>();
  }

  public void addInstance(Instance instance) {
    instanceList.add(instance);
  }

  public Map<String, Vector<String>> getNomina() {
    return nomina;
  }
}