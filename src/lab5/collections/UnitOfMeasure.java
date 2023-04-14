package lab5.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Enumeration of the Unit of measure which could be used in Product
 */
public enum UnitOfMeasure {
    CENTIMETERS,
    LITERS,
    GRAMS;
    /**
     * This method print all type of the unit of measure
     * @return linkedlist which contain all type of the organization
     */
    public static List<UnitOfMeasure> printAllUnitOfMeasure() {
        UnitOfMeasure[] values = UnitOfMeasure.values();
        ArrayList<UnitOfMeasure> allValue= new ArrayList<>();
        allValue.addAll(Arrays.asList(values));
        return allValue;
    }
}
