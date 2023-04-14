package lab5.commands;

import lab5.Exceptions.CommandsException.CommandNeedAnArg;
import lab5.Exceptions.CommandsException.NoSuchElementException;
import lab5.Exceptions.CommandsException.WrongAmountArgs;
import lab5.Util.productAdder;
import lab5.collections.Product;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This command is replacing the value by key if the new value of the product price is less than the old one
 */

public class replaceIfLowerPrice extends AbstractCommand {
    CollectionManager collectionManager;

    public replaceIfLowerPrice() {
        super("replaceIfLowerPrice", "replace the value by key if the new value of the product price is less than the old one");
        collectionManager = CollectionManager.getInstance();
    }

    @Override
    public void execute(String[] args) {
        try {
            if(args.length > 2){
                throw new WrongAmountArgs();
            }
            if(args.length == 1){
                throw new CommandNeedAnArg();
            }
            int id;
            Product newProduct;
            id = Integer.parseInt(args[1].trim());
            if(collectionManager.getProductCollection().get(id) == null){
                throw new NoSuchElementException();
            }
            newProduct = new productAdder().askUserNewProduct();
            if (newProduct.getPrice() < collectionManager.getById(id).getPrice()){
                collectionManager.addToCollection(id, newProduct);
                Console.println("New product in collection!");}
            else{
                Console.println("New product is more expensive than old one");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (WrongAmountArgs e){
                Console.printError("No such arguments for " + getName());
        }catch (CommandNeedAnArg e){
                Console.printError("Command: " + getName() + " is needed an argument");}
        catch (NoSuchElementException e) {
            Console.printError("No element in Collection with such id");
        }
    }
}
