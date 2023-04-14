package lab5.Util.FileProcessing;

import lab5.collections.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Reader {
    public static ArrayList<String[]> readFile(String filePath) {
        String delimeter = ";";
        ArrayList<String[]> products = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String line;
            input.readLine();
            while ((line = input.readLine()) != null) {
                String[] row = line.split(delimeter);
                products.add(row);
            }
            return products;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
