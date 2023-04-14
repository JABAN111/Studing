package lab5.commands;

import lab5.Exceptions.CommandsException.CommandNeedAnArg;
import lab5.Exceptions.CommandsException.NoSuchElementException;
import lab5.Exceptions.CommandsException.WrongAmountArgs;
import lab5.collections.Product;
import lab5.managers.CollectionManager;
import lab5.managers.Console;
import lab5.Util.productAdder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This command is updating the value of a collection item which id is equal to the specified one
 */
public class updateId extends AbstractCommand{
    CollectionManager collectionManager;
    public updateId() {
        super("updateId", "update the value of a collection item which id is equal to the specified one");
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
            Product newProduct;
            id = Integer.parseInt(args[1].trim());
            if(collectionManager.getProductCollection().get(id) == null)
                throw new NoSuchElementException();
            newProduct = new productAdder().askUserNewProduct();
            collectionManager.addToCollection(id,newProduct);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchElementException e) {
            Console.printError("No element with such id in collection");
        }catch (WrongAmountArgs e){
            Console.printError("No such arguments for " + getName());
        }catch (CommandNeedAnArg e){
            Console.printError("Command: " + getName() + " is needed an argument");
        }
    }
}
