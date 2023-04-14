package lab5.Util.FileProcessing;


import lab5.managers.Console;

import java.io.*;
import java.util.ArrayList;

public class CsvReaderScripts {
    /**
     * read csv file and return it arraylist of used commands
     */
    public static ArrayList<String[]> readScript(String pathOfFile){
        String line = "";
        String delimiter = ",";
        ArrayList<String[]> data = new ArrayList<>();
        try(BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(pathOfFile)))){
            while((line = input.readLine()) != null){
                String[] row = line.split(delimiter);
                data.add(row);
            }
        } catch (FileNotFoundException e) {
            Console.printError("Not such file in this folder");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
