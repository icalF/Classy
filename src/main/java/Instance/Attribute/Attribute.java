package Instance.Attribute;

import java.util.*;
import java.lang.*;

/**
 * Class attribute
 * 
 * @author Afrizal Fikri
 */
public abstract class Attribute <T> {
  private T value;  
  private AttributeType type;
  private T[] members;
}