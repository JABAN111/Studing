package lab5.commands;

import lab5.Exceptions.CommandsException.WrongAmountArgs;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

/**
 * This command is printing the average value of the price field for all items in the collection
 */
public class averageOfPrice extends AbstractCommand{
    private static CollectionManager collectionManager;

    public averageOfPrice() {
        super("averageOfPrice", "print the average value of the price field for all items in the collection");
        collectionManager = CollectionManager.getInstance();
    }

    @Override
    public void execute(String[] args) {
        try {
            if(args.length != 1)
                throw new WrongAmountArgs();
            if (collectionManager.getProductCollection().size() == 0)
                Console.println("Current average is 0");
            else {
                float priceOfElements = 0f;
                int cnt = 0;
                for (Integer id : collectionManager.getProductCollection().keySet()) {
                    priceOfElements += collectionManager.getProductCollection().get(id).getPrice();
                    cnt += 1;
                }
                float average = priceOfElements / cnt;
                Console.println("Current average is " + average);
            }
        }catch (WrongAmountArgs e){
            Console.printError("No such arguments for " + getName());
        }
    }
    }

