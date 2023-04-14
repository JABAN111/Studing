package lab5.commands;

import lab5.Exceptions.CommandsException.CollectionIsEmptyException;
import lab5.Exceptions.CommandsException.CommandNeedAnArg;
import lab5.Exceptions.CommandsException.WrongAmountArgs;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

/**
 * This command is removing all items from the collection whose key is less than the specified one
 */

public class removeLowerKey extends AbstractCommand{
    CollectionManager collectionManager;
    public removeLowerKey(){
        super("removeLowerKey","remove all items from the collection whose key is less than the specified one");
        collectionManager = CollectionManager.getInstance();
    }

    @Override
    public void execute(String[] args) {
        try{
            if(args.length > 2){
                throw new WrongAmountArgs();
            }
            if(args.length == 1){
                throw new CommandNeedAnArg();
            }
            int largestId;
            int cntDeletedProducts = 0;
            largestId = Integer.parseInt(args[1].trim());
            if(collectionManager.getProductCollection().size() != 0) {
                int maxKeyInCollection = Collections.max(collectionManager.getProductCollection().keySet());
                for (int currentId = 1; currentId <= maxKeyInCollection; currentId++) {
                    if (currentId < largestId) {
                        collectionManager.removeByIdFromCollection(currentId);
                        cntDeletedProducts += 1;
                    }
                }
            }
            else
                throw new CollectionIsEmptyException();
            Console.println("Was deleted: "  + cntDeletedProducts);
        } catch (CollectionIsEmptyException e) {
            Console.printError("Collection is empty");
        } catch (WrongAmountArgs e){
            Console.printError("No such arguments for " + getName());
        }catch (CommandNeedAnArg e){
            Console.printError("Command: " + getName() + " is needed an argument");}
    }
}
