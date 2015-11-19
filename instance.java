import java.util.*;
import java.lang.*;

class Instance {
  private Vector<Comparable> instanceAttributes;
  private Map<String, Integer> attributeIndices;
  private String label;

  public Instance(Vector<String> attributeNames) {
    attributeIndices = new HashMap<String, Integer>();
    instanceAttributes = new Vector<Comparable>(attributeNames.size());
    label = "?";
    
    int counter = 0;
    for (String s : attributeNames) {
      attributeIndices.put(s, counter++);
    }
  }

  public Vector getList() { return instanceAttributes; }

  public Comparable get(String attributeName) {
    return instanceAttributes.get(attributeIndices.get(attributeName));
  }

  public void set(String attributeName, Comparable val) {
    instanceAttributes.set(attributeIndices.get(attributeName), val);
  }

  public void setLabel(String label) { this.label = label; }

  public String getLabel() { return this.label; }
}

class InstanceSet {
  private Vector<Instance> instanceList;
  private Vector<String> attributeNames;

  public InstanceSet(Vector<String> attributeNames) {
    this.attributeNames = attributeNames;
    instanceList = new Vector<Instance>(attributeNames.size());
  }

  public void addInstance(Instance instance) {
    instanceList.add(instance);
  }

  public int size() { return instanceList.size(); }

  public Instance get(int k) {
    return instanceList.get(k);
  }
}