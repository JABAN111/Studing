package lab5.managers;

import lab5.Util.FileProcessing.AutoCollection;
import lab5.Util.FileProcessing.Writter;
import lab5.Util.Validators.CoordinatesValidator;
import lab5.Util.Validators.OrganizationValidator;
import lab5.Util.Validators.ProductValidator;
import lab5.collections.*;

import java.time.ZonedDateTime;
import java.util.LinkedHashMap;


/**
 * This class manage the whole collections from lab5.collections
 *
 */
public class CollectionManager {
    private static CollectionManager collectionManager;
    private String filePath;
    private static LinkedHashMap<Integer, Product> productCollection;
    private final ZonedDateTime creationDate;
    private final OrganizationValidator organizationValidator;
    private final ProductValidator productValidator;
    private final CoordinatesValidator coordinatesValidator;

    public CollectionManager() {
        productCollection = new LinkedHashMap<>();
        creationDate = ZonedDateTime.now();
        productValidator = new ProductValidator();
        organizationValidator = new OrganizationValidator();
        coordinatesValidator = new CoordinatesValidator();
    }

    /**
     * * The CollectionManager class is a singleton that manages a collection of objects.
     * This class contains the getInstance() method, which returns an instance of the CollectionManager class.
     * If an instance has not been created yet, the method creates it and returns it.
     *
     * @return instance of the CollectionManager class
     */
    public static CollectionManager getInstance(){
        if(collectionManager == null)
            collectionManager = new CollectionManager();
        return collectionManager;
    }

    /**
     * Get the creation time of the collection
     *
     * @return ZondedDateTime of created collection
     */
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Give the information about the collection of products
     *
     * @return return LinkedHashMap of product which has id(id of the product)
     * !!!PROBABLY NEEDED TO CHANGE THE KEY FOR MAP OR CHANGE SOMETHING IN PRODUCT TO ESCAPE THE DUPLICATED INFORMATION!!!
     * as Key and Product as Value
     */
    public static LinkedHashMap<Integer, Product> getProductCollection() {
        return productCollection;
    }


    /**
     * This method generates uniq id for the product
     *
     * @return return uniq id for productCollection
     */
    public int generateNewId() {
        int id = 0;
        for (Integer key : productCollection.keySet()) {
            if (key >= 0 && key >= id)
                id = key;
        }
        return id + 1;
    }

    /**
     * This method gives the information about Product in LinkedHashMap by its id
     *
     * @param id is input int which we're looking for
     * @return the product by the id in productCollection
     */
    public Product getById(int id) {
        return productCollection.get(id);
    }

    /**
     * This method adds new Product for collection and give the id for this product
     * @param id which would be used as a key for the product
     * @param product which would added to the collection
     */
    public boolean addToCollection(int id, Product product) {
        if (product.getOrganization() != null) {
            if (productValidator.validate(product) && organizationValidator.validate(product.getOrganization()) && coordinatesValidator.validate(product.getCoordinates())) {
                productCollection.put(id, product);
                return true;
            }
        } else if (productValidator.validate(product) && coordinatesValidator.validate(product.getCoordinates())) {
            productCollection.put(id, product);
            return true;
        } else {
            Console.printError("Invalid product");
            return false;
        }
        return false;
    }
    /**
     * This method remove Product from the collection by its id
     * @param id of the product which needed to be deleted
     */
    public void removeByIdFromCollection(int id){
        productCollection.remove(id);
    }

    /**
     * This method is needed to delete all elements from the collection
     */
    public  void clear(){
        collectionManager.productCollection.clear();
    }

    public  void saveToFile(){
        Writter.Write(collectionManager.filePath);
    }
    public void setFilePath(String file){
        filePath = file;
    }

    public String collectionInfo(){
        return "Type: " + getInstance().getProductCollection().getClass() + "\n"+ "Creation time: " + getCreationDate() + "\n" +"amount of the products: " + productCollection.size();
    }
}
