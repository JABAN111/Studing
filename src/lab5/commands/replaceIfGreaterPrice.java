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
 * This command is replacing the value by key if the new value is greater than the old one
 */

public class replaceIfGreaterPrice extends AbstractCommand{
    CollectionManager collectionManager;
    public replaceIfGreaterPrice(){
        super("replaceIfGreaterPrice", "replace the value by key if the new value is greater than the old one");
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
                Console.println("Enter the id with which you want to compare");
                BufferedReader inputId = new BufferedReader(new InputStreamReader(System.in));
                id = Integer.parseInt(inputId.readLine().trim());
                newProduct = new productAdder().askUserNewProduct();
                if(collectionManager.getProductCollection().get(id) == null){
                    throw new NoSuchElementException();
                }
                if (newProduct.getPrice() > collectionManager.getById(id).getPrice())
                    collectionManager.addToCollection(id, newProduct);
            } catch (IOException e) {
                throw new RuntimeException(e);

            } catch (NoSuchElementException e) {
                Console.printError("No element in Collection with such id");
            }
    }
}
