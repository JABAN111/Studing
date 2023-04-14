package lab5.commands;

import lab5.Exceptions.CommandsException.CollectionIsEmptyException;
import lab5.Exceptions.CommandsException.WrongAmountArgs;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

/**
 * This command is showing all elements of the collection as String
 */
public class show extends AbstractCommand{
    private CollectionManager collectionManager;
    public show() {
        super("show", "output to the standard output stream all the elements of the collection in a string representation");
        collectionManager = CollectionManager.getInstance();
    }

    @Override
    public void execute(String[] args) {
        try {
            if(args.length != 1)
                throw new WrongAmountArgs();
            if (collectionManager.getProductCollection().size() != 0)
                for (Integer id : collectionManager.getProductCollection().keySet()){
                    Console.println("");
                    Console.println("id: " + id + "\n" + collectionManager.getProductCollection().get(id));
        }
            else
                throw new CollectionIsEmptyException();
        } catch (CollectionIsEmptyException e) {
            Console.printError("Collection is empty");
        }catch (WrongAmountArgs e){
            Console.printError("No such arguments for " + getName());
        }
    }
}
