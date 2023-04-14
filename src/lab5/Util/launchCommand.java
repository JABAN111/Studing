package lab5.Util;


import lab5.commands.*;
import lab5.managers.Console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;


public class launchCommand {
    private String commandName;
    private static ArrayList<AbstractCommand> listCommand = CommandFactory.getListCreatedCommands();

    public launchCommand(String commandName) {
        this.commandName = commandName;
    }

    public static boolean executeCommand(String commandName) {
        try {
            String[] comWithArg = commandName.split(" ");
            for (AbstractCommand command : listCommand) {
                if (command.toString().equals(comWithArg[0])) {
                    command.execute(comWithArg);
                    return true;
                }
            }
            Console.printError("No such command, use help if u need help");
            return false;
        } catch (IOException e) {
            Console.printError(new RuntimeException());
        } catch (NoSuchElementException e){
            Console.printError("Doesn't support such type of input");
        }
        return false;
    }

}

