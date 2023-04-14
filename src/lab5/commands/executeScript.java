package lab5.commands;

import lab5.Exceptions.CommandsException.CommandNeedAnArg;
import lab5.Exceptions.CommandsException.WrongAmountArgs;
import lab5.Exceptions.NoSuchFileException;
import lab5.Util.FileProcessing.CsvReaderScripts;
import lab5.Util.launchCommand;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * This command is reading and executing the script from the specified file. The script contains commands in the same form in which they are entered by the user in interactive mode
 */
public class executeScript extends AbstractCommand{
    CollectionManager collectionManager;
    public executeScript(){
        super("executeScript", "read and execute the script from the specified file. The script contains commands in the same form in which they are entered by the user in interactive mode");
        collectionManager = CollectionManager.getInstance();
    }
    @Override
    public void execute(String[] args) {
        try{
            Console.setScriptStatus(true);
            if(args.length > 2){
                throw new WrongAmountArgs();
            }
            if(args.length == 1){
                throw new CommandNeedAnArg();
            }
            String path = args[1];
            ArrayList<String[]> data = CsvReaderScripts.readScript(path);
            Console.setScriptCommands(data);
            Console.launchScript();
        }
        catch (IOException e){
            Console.printError("IOEexception");
        }catch (WrongAmountArgs e){
            Console.printError("No such arguments for " + getName());
        }catch (CommandNeedAnArg e){
            Console.printError("Command: " + getName() + " is needed an argument");
        }
    }
}
