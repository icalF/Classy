package id.koneko096.Classy.Util;

import id.koneko096.Classy.Data.Attribute;
import id.koneko096.Classy.Data.Instance;

import java.util.List;
import java.util.stream.Collectors;

public class DataPreparationUtil {

    private DataPreparationUtil() {
        
    }

    public  static List<Double> convertToListOfDouble(Instance instance) {
        try {
            return instance.stream().map(i -> (Double) i.getValue()).collect(Collectors.toList());
        } catch (ClassCastException e) {
            throw new RuntimeException("Fails to convert instance property to float\n", e);
        }
    }

    public static List<Integer> convertToListOfInteger(Instance instance) {
        return instance.stream().map(Attribute::hashCode).collect(Collectors.toList());
    }
}
