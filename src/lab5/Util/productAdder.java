package lab5.Util;

import lab5.collections.Coordinates;
import lab5.collections.Product;
import lab5.collections.UnitOfMeasure;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is necessary for interactive interaction with the user
 * It will call methods of the Product class from the collection and insert
 * This class has a basic static method that will ask the user for input.
 */

public class productAdder {
    private static CollectionManager collectionManager;
    private Product newProduct;

    public productAdder(){
        collectionManager = CollectionManager.getInstance();
    }
    private String askName() throws IOException {
        String name;
        Console.println("Enter the name of the product: " );
        Console.print("> ");
        BufferedReader inputName = new BufferedReader(new InputStreamReader(System.in));
        name = inputName.readLine().trim();
        return name;
    }
    private double askX() throws IOException {
        double xCoordinate;
        Console.println("Enter the X coordinate of the product: ");
        Console.print("> ");
        BufferedReader inputCoordinate = new BufferedReader(new InputStreamReader(System.in));
        xCoordinate = Double.parseDouble(inputCoordinate.readLine().trim());
        return xCoordinate;
    }
    private int askY() throws IOException {
        int yCoordinate;
        Console.println("Enter the Y coordinate of the product: ");
        Console.print("> ");
        BufferedReader inputCoordinate = new BufferedReader(new InputStreamReader(System.in));
        yCoordinate = Integer.parseInt(inputCoordinate.readLine().trim());
        return yCoordinate;
    }
    private Float askPrice() throws IOException{
        Float price;
        Console.println("Enter the price of the product: ");
        Console.print("> ");
        BufferedReader inputPrice = new BufferedReader(new InputStreamReader(System.in));
        price = Float.parseFloat(inputPrice.readLine().trim());
        return price;
    }
    private int askManufactureCost() throws IOException{
        int manufactureCost;
        Console.println("Enter the Manufacture cost of the product: ");
        Console.print("> ");
        BufferedReader inputPrice = new BufferedReader(new InputStreamReader(System.in));
        manufactureCost = Integer.parseInt(inputPrice.readLine().trim());
        return manufactureCost;
    }
    private UnitOfMeasure askUnitOfMeasure() throws IOException {
        UnitOfMeasure unitOfMeasure;
        Console.println(UnitOfMeasure.printAllUnitOfMeasure());
        Console.println("Chose and enter one of the unit of measure from the list for the new product: ");
        Console.print("> ");
        BufferedReader inputUnitOfMeasure = new BufferedReader(new InputStreamReader(System.in));
        unitOfMeasure = UnitOfMeasure.valueOf(inputUnitOfMeasure.readLine().trim().toUpperCase());
        return unitOfMeasure;
    }
    public Product askUserNewProduct() throws IOException {
        collectionManager = CollectionManager.getInstance();
        Console.println("Do you want to put info about manufacture?Y/n");
        BufferedReader org = new BufferedReader(new InputStreamReader(System.in));
        String inputAnswer = org.readLine().trim();
        if(inputAnswer.equalsIgnoreCase("Y")) {
            Coordinates coordinates = new Coordinates(askX(), askY());
            newProduct = new Product(askName(), coordinates, askPrice(), askUnitOfMeasure(), askManufactureCost(), new organizationAdder().askUserAboutOrganization());
        }
        else if(inputAnswer.equalsIgnoreCase("n")){
            Coordinates coordinates = new Coordinates(askX(), askY());
            newProduct = new Product(askName(), coordinates, askPrice(), askUnitOfMeasure(), askManufactureCost());
        }
        else{
            Console.printError("You should enter Y or n, wtf");
            askUserNewProduct();}
        return newProduct;
    }
    
}
