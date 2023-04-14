package lab5.commands;

import lab5.Exceptions.CommandsException.WrongAmountArgs;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

/**
 * This command is streaming information about collection to the standard output
 */
public class info extends AbstractCommand{
    private static CollectionManager collectionManager;
    public info() {
        super("info","Show info about collection");
        collectionManager = CollectionManager.getInstance();
    }

    @Override
    public void execute(String[] args) {
        try{
            if(args.length != 1)
                throw new WrongAmountArgs();
            Console.println(collectionManager.collectionInfo());
        }catch (WrongAmountArgs e){
            Console.printError("No such arguments for " + getName());
        }
    }
}