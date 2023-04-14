package lab5.collections;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Enumeration of the organization types
 */

public enum OrganizationType {
    PUBLIC,
    GOVERNMENT,
    PRIVATE_LIMITED_COMPANY;

    /**
     * This method print all type of the organization
     * @return linkedlist which contain all type of the organization
     */
    public static ArrayList<OrganizationType> printAllOrganizations() {
        OrganizationType[] values = OrganizationType.values();
        ArrayList<OrganizationType> allValue= new ArrayList<>();
        allValue.addAll(Arrays.asList(values));
        return allValue;
    }

}

