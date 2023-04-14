package lab5.commands;

import lab5.Exceptions.CommandsException.WrongAmountArgs;
import lab5.Util.FileProcessing.Writter;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

import java.io.IOException;

/**
 * This command is saving the collection to a file
 */
public class save extends AbstractCommand{
    CollectionManager collectionManager;
    public save(){
        super("save", "Save collection to the file");
        collectionManager = CollectionManager.getInstance();
    }
    @Override
    public void execute(String[] args) {
        try{
            if(args.length != 1)
                throw new WrongAmountArgs();
            collectionManager.saveToFile();
        }catch (WrongAmountArgs e){
            Console.printError("No such arguments for " + getName());
        }
}
}
