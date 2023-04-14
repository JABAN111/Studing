package lab5.Util.FileProcessing;


import lab5.collections.Product;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

import java.io.*;
import java.util.LinkedHashMap;

public class Writter {
    private static CollectionManager collectionManager = CollectionManager.getInstance();

    /**
     * @return true if everything was written into the file without any mistakes
     */
    public static boolean Write(String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            String delimetr = ";";
            LinkedHashMap<Integer, Product> collectionToSave = collectionManager.getProductCollection();
            String firstRow = "ID;" +
                    "Product Name;" +
                    "Coordinates;" +
                    "Creation time;" +
                    "Price;" +
                    "Unit of measure;" +
                    "Manufacture cost;" +
                    "Organization ID;" +
                    "Organization name;" +
                    "Organization full name;" +
                    "Organization count of employees;" +
                    "Type of organization";
            bufferedWriter.write(firstRow);
            bufferedWriter.newLine();
            for (int i : collectionToSave.keySet()) {
                String[] row = collectionToSave.get(i).getInfoAboutProduct().split("\n");
                String lastElement = row[row.length - 1];
                bufferedWriter.write(i + ";");
                for(String currentInfo : row) {
                    if(!currentInfo.equals(lastElement))
                        bufferedWriter.write(currentInfo + ";");
                    else{
                        bufferedWriter.write(lastElement);
                        bufferedWriter.write("\n");}
                }
            }
            Console.println("Collection is saved to: " + filePath);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
