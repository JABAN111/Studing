package lab5.managers;

import lab5.Util.FileProcessing.Reader;
import lab5.Util.launchCommand;
import lab5.collections.*;
import lab5.commands.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;


/**
 * This class is interactive with user and needed to input anything to console from user
 */
public class Console {
    private static final String PS1 = "$ ";
    private static CollectionManager collectionManager = CollectionManager.getInstance();
    private final ArrayList<AbstractCommand> listOfCommands;
    private static ArrayList<String[]> ScriptList;

    private static boolean ScriptStatus;

    public Console(boolean userMode){
        listOfCommands = CommandFactory.getListCreatedCommands();
        collectionManager = CollectionManager.getInstance();
    }

    /**
     * Launch the script which user input
     */
    public static void launchScript() throws IOException {
        if (ScriptStatus) {
            ArrayList<String[]> listCommands = getScriptCommands();
            boolean flag = false;
            boolean flagOfCurrentInserting = false;
            ArrayList<String> infoProduct = new ArrayList<>();
            for (String[] rowCommands : listCommands) {
                if (rowCommands[0].equals("insertElement") || rowCommands[0].equals("replaceIfGreaterPrice") || rowCommands[0].equals("replaceIfLoverPrice")) {
                    flagOfCurrentInserting = true;

                }
                if (CommandFactory.getListCreatedComm().contains(rowCommands[0]))
                    launchCommand.executeCommand(rowCommands[0]);
                if (!CommandFactory.getListCreatedComm().contains(rowCommands[0]) &&  flagOfCurrentInserting) {
                    infoProduct.add(rowCommands[0]);
                    if(infoProduct.size() >= 7)
                        flag = true;
                }
                else if(CommandFactory.getListCreatedComm().contains(rowCommands[0])){
                    for (String currentCommand : rowCommands) {
                        launchCommand.executeCommand(currentCommand);
                    }
                }
                if (flag) {
                    if (infoProduct.get(0).equalsIgnoreCase("n")) {
                        Coordinates coordinates = new Coordinates(Double.parseDouble(infoProduct.get(1)), Integer.parseInt(infoProduct.get(2)));
                        collectionManager.addToCollection(collectionManager.generateNewId(), new Product(infoProduct.get(3), coordinates, Float.parseFloat(infoProduct.get(4)), UnitOfMeasure.valueOf(infoProduct.get(5).toUpperCase()), Integer.parseInt(infoProduct.get(6))));
                    }
                    if (infoProduct.get(0).equalsIgnoreCase("Y")) {
                        Coordinates coordinates = new Coordinates(Double.parseDouble(infoProduct.get(1)), Integer.parseInt(infoProduct.get(1)));
                        collectionManager.addToCollection(collectionManager.generateNewId(), new Product(infoProduct.get(4), coordinates, Float.parseFloat(infoProduct.get(5)), UnitOfMeasure.valueOf(infoProduct.get(6)), Integer.parseInt(infoProduct.get(7)), new Organization(infoProduct.get(8), infoProduct.get(9), Integer.parseInt(infoProduct.get(10)), OrganizationType.valueOf(infoProduct.get(11)))));
                    }
                    infoProduct.clear();
                    flag = false;
                }

            }

        }

    }



    public static void setScriptCommands(ArrayList<String[]> list){
        ScriptList = list;
    }

    public static ArrayList<String[]> getScriptCommands(){
        return ScriptList;
    }

    public static void setScriptStatus(boolean scriptStatus) {
        ScriptStatus = scriptStatus;
    }
    public static boolean getScriptStatus(){
        return ScriptStatus;
    }

    /**
     * Interactive mode for work with user
     */
    public static void interactiveMode(){
        try {
            String userCommand;
            do {
                Console.print(PS1);
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                String line = userInput.readLine();
                if(line != null){
                    userCommand = line.trim();
                    launchCommand.executeCommand(userCommand);}
                else
                    throw new NoSuchElementException();
            }
            while (true);
        } catch (IOException e) {
            Console.printError(Arrays.stream(e.getStackTrace()).toArray());
        } catch (NoSuchElementException e){
            System.exit(0);
        }
    }


    /**
     * print information to console
     */
    public static void print(Object toOut){System.out.print(toOut);}

    /**
     * print information to console and use enter after input
     */
    public static void println(Object toOut){System.out.println(toOut);}

    /**
     * print information about errors
     */
    public static void printError(Object e){System.err.println("Error: " + e);}
}
