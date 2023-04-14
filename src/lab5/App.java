package lab5;

import lab5.Exceptions.CommandsException.NoSuchElementException;
import lab5.Exceptions.NoSuchFileException;
import lab5.Util.FileProcessing.AutoCollection;
import lab5.managers.CollectionManager;
import lab5.managers.Console;


public class App {
    public static void main(String[] args) {
//        CollectionManager collectionManager = CollectionManager.getInstance();
//        collectionManager.setFilePath("src/lab5/file.csv");
//        new AutoCollection().addCollection("src/lab5/file.csv");
//        Console.interactiveMode();
        try {
            CollectionManager collectionManager = CollectionManager.getInstance();
            if (args[0] != null) {
                collectionManager.setFilePath(args[0]);
                new AutoCollection().addCollection(args[0]);
            } else
                throw new NoSuchFileException();
            Console.interactiveMode();
        } catch (NoSuchFileException e) {
            Console.printError("User should input file to read");
            System.exit(0);
        }
    }
}