package lab5.commands;

import lab5.Exceptions.CommandsException.WrongAmountArgs;
import lab5.managers.Console;

/**
 * This command is showing whole all available command
 */
public class help extends AbstractCommand{
    public help() {
        super("help", "Showing whole all available commands");
    }

    @Override
    public void execute(String[] args) {
        try {
            if (args.length != 1)
                throw new WrongAmountArgs();

            for (AbstractCommand command : CommandFactory.getListCreatedCommands())
                Console.println("Name: " + command + "; Description: " + command.getDescription());
        }catch (WrongAmountArgs e){
        Console.printError("No such arguments for " + getName());
        }
    }
}
