import java.util.*;
import java.lang.*;

/**
 * Class instance
 * 
 * @author Afrizal Fikri
 */
class Instance {
  private Map<String, Integer> attributeIndices;
  private Vector<Comparable> instanceAttributes;
  private String label;

  /**
   * Constructor
   * @param  attributeNames
   */
  public Instance(Vector<String> attributeNames) {
    attributeIndices = new HashMap<String, Integer>();
    instanceAttributes = new Vector<Comparable>(attributeNames.size());
    label = "?";
    
    int counter = 0;
    for (String s : attributeNames) {
      attributeIndices.put(s, counter++);
    }
  }

  /**
   * List of attributes getter
   * @return vector of string list of attribute values
   */
  public Vector getList() { return instanceAttributes; }

  /**
   * Getter attribute value by attr name
   * @param  attributeName
   * @return attr value
   */
  public Comparable get(String attributeName) {
    return instanceAttributes.get(attributeIndices.get(attributeName));
  }

  /**
   * Setter attribute value by attr name
   * @param attributeName 
   * @param value           
   */
  public void set(String attributeName, Comparable val) {
    instanceAttributes.set(attributeIndices.get(attributeName), val);
  }

  /**
   * Set the class label of current instance
   * @param label
   */
  public void setLabel(String label) { this.label = label; }

  /**
   * Set the class label of current instance
   * @return label
   */
  public String getLabel() { return this.label; }
}

/**
 * Class instance-set
 *
 * @author Afrizal Fikri
 */
class InstanceSet {
  private Vector<Instance> instanceList;
  private Vector<String> attributeNames;

  /**
   * Constructor
   * @param  attributeNames
   */
  public InstanceSet(Vector<String> attributeNames) {
    this.attributeNames = attributeNames;
    instanceList = new Vector<Instance>(attributeNames.size());
  }

  /**
   * Get list attribute names
   * @return  attribute names
   */
  public Vector<String> getAttributes() { return attributeNames; }

  /**
   * Add new instance
   * @param instance
   */
  public void add(Instance instance) {
    instanceList.add(instance);
  }

  /**
   * Get instance number
   * @return  size of instanceList
   */
  public int size() { return instanceList.size(); }

  /**
   * Instance getter
   * @param  index num
   * @return instance
   */
  public Instance get(int k) {
    return instanceList.get(k);
  }

  /**
   * Get all instances
   * @return list instaces
   */
  public Vector<Instance> getList() {
    return instanceList;
  }
}