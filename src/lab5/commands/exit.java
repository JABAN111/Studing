package lab5.commands;

import lab5.Exceptions.CommandsException.WrongAmountArgs;
import lab5.managers.Console;

/**
 * This command is terminating the program (without saving to a file)
 */
public class exit extends AbstractCommand{
    public exit() {
        super("exit", "terminate the program (without saving to a file)");
    }

    @Override
    public void execute(String[] args) {
        try{
            if(args.length != 1)
                throw new WrongAmountArgs();
            System.exit(0);
        }catch (WrongAmountArgs e){
            Console.printError("No such arguments for " + getName());
        }
    }
}
