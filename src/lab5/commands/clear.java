package lab5.commands;

import lab5.Exceptions.CommandsException.WrongAmountArgs;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

/**
 * This command is clearing the collection
 */
public class clear extends AbstractCommand {
    private static CollectionManager collectionManager;
    public clear() {
        super("clear", "clear the collection");
        clear.collectionManager = CollectionManager.getInstance();
    }

    @Override
    public void execute(String[] args) {
        try {
            if (args.length != 1)
                throw new WrongAmountArgs();
            if (collectionManager.getProductCollection().size() != 0)
                collectionManager.clear();
            Console.println("Collection was cleared");
        }catch (WrongAmountArgs e){
        Console.printError("No such arguments for " + getName());}
    }
}



