package lab5.commands;

import java.util.ArrayList;

/**
 * This class has method to create all instance of the command
 */

public class CommandFactory {
    public static AbstractCommand createCommands(String commandType) {
        switch (commandType) {
            case "clear":
                return new clear();
            case "help":
                return new help();
            case "exit":
                return new exit();
            case "averageOfPrice":
                return new averageOfPrice();
            case "info":
                return new info();
            case "removeKey":
                return new removeKey();
            case "insertElement":
                return new insertElement();
            case "show":
                return new show();
            case "counterGreaterThanPrice":
                return new counterGreaterThanPrice();
            case "printUniqueUnitOfMeasure":
                return new printUniqueUnitOfMeasure();
            case "updateId":
                return new updateId();
            case "replaceIfLowerPrice":
                return new replaceIfLowerPrice();
            case "removeLowerKey":
                return new removeLowerKey();
            case "replaceIfGreaterPrice":
                return new replaceIfGreaterPrice();
            case "save":
                return new save();
            case "executeScript":
                return new executeScript();
            default:
                throw new IllegalArgumentException("Invalid command type: " + commandType);
        }
    }
    public static ArrayList<AbstractCommand> getListCreatedCommands(){
        ArrayList<AbstractCommand> listCommand = new ArrayList<>();
        listCommand.add(createCommands("clear"));
        listCommand.add(createCommands("help"));
        listCommand.add(createCommands("exit"));
        listCommand.add(createCommands("averageOfPrice"));
        listCommand.add(createCommands("info"));
        listCommand.add(createCommands("removeKey"));
        listCommand.add(createCommands("insertElement"));
        listCommand.add(createCommands("show"));
        listCommand.add(createCommands("counterGreaterThanPrice"));
        listCommand.add(createCommands("printUniqueUnitOfMeasure"));
        listCommand.add(createCommands("updateId"));
        listCommand.add(createCommands("replaceIfLowerPrice"));
        listCommand.add(createCommands("removeLowerKey"));
        listCommand.add(createCommands("replaceIfGreaterPrice"));
        listCommand.add(createCommands("save"));
        listCommand.add(createCommands("executeScript"));
        return listCommand;
    }
    //это костылек
    public static ArrayList<String> getListCreatedComm(){
        ArrayList<String> listCommandstr = new ArrayList<>();
        listCommandstr.add("clear");
        listCommandstr.add("help");
        listCommandstr.add("exit");
        listCommandstr.add(("averageOfPrice"));
        listCommandstr.add(("info"));
        listCommandstr.add(("removeKey"));
        listCommandstr.add("insertElement");
        listCommandstr.add(("show"));
        listCommandstr.add(("counterGreaterThanPrice"));
        listCommandstr.add(("printUniqueUnitOfMeasure"));
        listCommandstr.add(("updateId"));
        listCommandstr.add(("replaceIfLowerPrice"));
        listCommandstr.add(("removeLowerKey"));
        listCommandstr.add(("replaceIfGreaterPrice"));
        listCommandstr.add(("save"));
        listCommandstr.add(("executeScript"));
        return listCommandstr;
    }

}
