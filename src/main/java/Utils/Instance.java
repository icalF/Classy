package Utils;

import java.util.*;
import java.lang.*;

/**
 * Class instance
 * 
 * @author Afrizal Fikri
 */
public class Instance {
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
