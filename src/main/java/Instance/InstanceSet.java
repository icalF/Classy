package Instance;

import java.util.*;
import java.lang.*;

/**
 * Class instance-set
 *
 * @author Afrizal Fikri
 */
public class InstanceSet {
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