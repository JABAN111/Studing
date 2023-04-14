package lab5.commands;

import lab5.Exceptions.CommandsException.WrongAmountArgs;
import lab5.Util.productAdder;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

import java.io.IOException;
import java.util.concurrent.CompletionService;

/**
 * This command is adding a new element with the specified key
 */
public class insertElement extends AbstractCommand{
    private CollectionManager collectionManager;
    public insertElement() {
        super("insertElement", "add a new element with the specified key");
        collectionManager = CollectionManager.getInstance();
    }

    @Override
    public void execute(String[] args) {
        try{
            if(!Console.getScriptStatus()) {
                if (args.length != 1)
                    throw new WrongAmountArgs();
                collectionManager.addToCollection(collectionManager.generateNewId(), new productAdder().askUserNewProduct());
                Console.println("Product was added");
            }
            else{

            }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }catch (WrongAmountArgs e){
            Console.printError("No such arguments for " + getName());
        }
    }

}
