package lab5.collections;


import java.time.ZonedDateTime;


/**
 * Class which represent the Product of organization
 */
public class Product{
    private String name;
    private Coordinates coordinates;
    private ZonedDateTime creationDate;
    private Float price;
    private int manufactureCost;
    private UnitOfMeasure unitOfMeasure;
    private Organization organization;


    public Product(String name, Coordinates coordinates, float price, UnitOfMeasure unitOfMeasure, int manufactureCost, Organization manufacturer) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.price = price;
        this.manufactureCost = manufactureCost;
        this.unitOfMeasure = unitOfMeasure;
        this.organization = manufacturer;
    }
    public Product(String name, Coordinates coordinates, float price, UnitOfMeasure unitOfMeasure, int manufactureCost) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.price = price;
        this.manufactureCost = manufactureCost;
        this.unitOfMeasure = unitOfMeasure;
    }

    /**
     * This method give the information about name of the product
     * @return name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * This method give the information about Coordinates of the product
     * @return coodinates of the product
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * This method give the information about the time when this product was created
     * @return time of the creation this product
     */
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * This method give the information about the price of the product
     * @return price of the product
     */
    public Float getPrice() {
        return price;
    }

    /**
     * This method give the information about the Manufacture cost
     * @return manufacture cost of the product
     */
    public int getManufactureCost() {
        return manufactureCost;
    }

    /**
     * This method keep information which Unit of measure is using
     * @return unit of measure of the product
     */
    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;   
    }

    /**
     * This method give information about the organization where product was produced
     * @return the manufacture info about the product
     */
    public Organization getOrganization() {
        return organization;
    }

    public String getInfoAboutProduct(){
        if (organization != null)
         return name + "\n" +
                coordinates.getCoordinates() + "\n" +
                creationDate + "\n" +
                price + "\n" +
                unitOfMeasure + "\n" +
                manufactureCost + "\n" +
                organization.getInfoAboutOrganization();
        else return name + "\n" +
                coordinates.getCoordinates() + "\n" +
                creationDate + "\n" +
                price + "\n" +
                unitOfMeasure + "\n" +
                manufactureCost + "\n";
    }

    /**
     * Give whole information about product
     * @return the whole information about the product
     */
    @Override
    public String toString() {
         return "Name: " + name + "\n" + "manufacture cost: " + manufactureCost + "\n" + "price: " + price + "\n" + "Unit of Measure: " + unitOfMeasure + "\n" +
                "Organization: " + organization + "\n" + "coordinates of X: " + coordinates.getX() + "\n" + "coordinates of Y: " + coordinates.getY();
    }
}
