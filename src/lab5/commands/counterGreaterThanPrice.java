package lab5.commands;

import lab5.Exceptions.CommandsException.CommandNeedAnArg;
import lab5.Exceptions.CommandsException.WrongAmountArgs;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This command is printing the number of items whose price field value is greater than the specified one
 */

public class counterGreaterThanPrice extends AbstractCommand{
    CollectionManager collectionManager;
    public counterGreaterThanPrice() {
        super("counterGreaterThanPrice", "print the number of items whose price field value is greater than the specified one");
        collectionManager = CollectionManager.getInstance();
    }
    @Override
    public void execute(String[] args) {
        try{
            if(args.length > 2){
                throw new WrongAmountArgs();
            }
            if(args.length == 1)
                throw new CommandNeedAnArg();
            float price;
            float currentPrice;
            int cnt = 0;
            price = Float.parseFloat(args[1]);
            for(Integer id : collectionManager.getProductCollection().keySet()){
                currentPrice = collectionManager.getProductCollection().get(id).getPrice();
                if(currentPrice > price)
                    cnt += 1;
            }
            Console.println("" + cnt);
        }
        catch (WrongAmountArgs e) {
            Console.printError("No such arguments for " + getName());
        }catch (CommandNeedAnArg e){
            Console.printError("Command: " + getName() + " is needed an argument");
        }
    }
}
