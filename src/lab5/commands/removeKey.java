package lab5.commands;

import lab5.Exceptions.CommandsException.CommandNeedAnArg;
import lab5.Exceptions.CommandsException.NoSuchElementException;
import lab5.Exceptions.CommandsException.WrongAmountArgs;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * This command is deleting Product from collection by its key
 */
public class removeKey extends AbstractCommand {
    private static CollectionManager collectionManager;
    public removeKey(){
        super("removeKey","remove from collection by key");
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
            int id;
            id = Integer.parseInt(args[1].trim());
            if(collectionManager.getProductCollection().size() != 0){
                collectionManager.removeByIdFromCollection(id);
                Console.println("Product with id: " + id + " was removed");
                }
            else
                throw new NoSuchElementException();
        } catch (NoSuchElementException e) {
            Console.printError("No such element in collection");
        }catch (WrongAmountArgs e){
            Console.printError("No such arguments for " + getName());
        }catch (CommandNeedAnArg e){
            Console.printError("Command: " + getName() + " is needed an argument");
        }
    }


}
