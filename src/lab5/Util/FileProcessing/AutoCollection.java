package lab5.Util.FileProcessing;

import lab5.collections.*;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

import java.util.ArrayList;

/**
 * This class is intended for auto-completion of the collection when the program starts
 */
public class AutoCollection {
    public AutoCollection(){}
    CollectionManager collectionManager = CollectionManager.getInstance();

    public void addCollection(String filePath) {
            ArrayList<String[]> file = Reader.readFile(filePath);
            for(String[] row : file){
                if(row.length == 7){
                    String[] inputCoordinates = row[2].split(",");
                    Coordinates coordinates = new Coordinates(Double.parseDouble(inputCoordinates[0]),Integer.parseInt(inputCoordinates[1]));
                    collectionManager.addToCollection(Integer.parseInt(row[0]),new Product(row[1],coordinates,Float.parseFloat(row[4]),UnitOfMeasure.valueOf(row[5]),Integer.parseInt(row[6])));
                }
                if(row.length == 12){
                    String[] inputCoordinates = row[2].split(",");
                    Coordinates coordinates = new Coordinates(Double.parseDouble(inputCoordinates[0]),Integer.parseInt(inputCoordinates[1]));
                    collectionManager.addToCollection(Integer.parseInt(row[0]),new Product(row[1],coordinates,Float.parseFloat(row[4]),UnitOfMeasure.valueOf(row[5]),Integer.parseInt(row[6]),new Organization(Integer.parseInt(row[7]),row[8],row[9],Integer.parseInt(row[10]),OrganizationType.valueOf(row[11]))));
                }
            }
            Console.println("import from the file is finished");
        }
    }

