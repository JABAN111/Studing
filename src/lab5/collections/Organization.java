package lab5.collections;

import lab5.managers.CollectionManager;

/**
 * This class represent the Organization
 */
public class Organization {
    private int id;
    private String name;
    private String fullName;
    private int employeesCount;
    private OrganizationType organizationType;

    public Organization(String name, String fullName, int employeesCount, OrganizationType organizationType){
        CollectionManager collectionManager = CollectionManager.getInstance();
        this.id = collectionManager.generateNewId();
        this.name = name;
        this.fullName = fullName;
        this.employeesCount = employeesCount;
        this.organizationType = organizationType;
    }
    public Organization(int id, String name, String fullName, int employeesCount, OrganizationType organizationType) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.employeesCount = employeesCount;
        this.organizationType = organizationType;
    }
    public Organization(String name,  int employeesCount) {
        CollectionManager collectionManager = CollectionManager.getInstance();
        this.id = collectionManager.generateNewId();
        this.name = name;
        this.fullName = null;
        this.employeesCount = employeesCount;
        this.organizationType = null;
    }
    /**
     * Get the id of the Organization
     *
     * @return the id of the Organization
     */
    public int getId() {
        return id;
    }

    /**
     * Get the name of the Organization
     * @return the name of the Organization
     */
    public String getName() {
        return name;
    }

    /**
     * Get the FullName of the Organization
     * @return FullName of the Organization
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Get the amount of the employee in the Organization
     * @return amount of the employee of the Organization
     */
    public int getEmployeesCount() {
        return employeesCount;
    }

    public String getInfoAboutOrganization(){
        return id + "\n" +
                name + "\n" +
                fullName + "\n" +
                employeesCount + "\n" +
                organizationType;
    }
    /**
     * Get the type of the Organization
     * @return type of Organization
     */
    public OrganizationType getOrganizationType() {
        return organizationType;
    }
    @Override
    public String toString(){
        return "organization name: " + name + "\n" +"organization full name: " + fullName + "\n" + "organization type: " + organizationType + "\n" + "employees count: " + employeesCount;
    }
}
