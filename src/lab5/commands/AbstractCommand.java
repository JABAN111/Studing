package lab5.commands;

import java.util.Objects;

/**
 * The abstract class is needed for all commands in the program.
 * AbstractCommand are implements Icommand. This interface contain two methods:
 *  getDescriptions();
 *  getName();
 *  by these methods user can get the whole information about this command.

 *  Abstract command has own:
 *  two fields: name and description
 *  and overrides methods: toString,hashCode,equals
 */
public abstract class AbstractCommand implements Icommand{
    private final String commandName;
    private final String description;

    public AbstractCommand(String commandName, String description) {
        this.commandName = commandName;
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
    /**
     * This method is implemented from Icommand and give name of the command
     * @return name of the current command
     */
    @Override
    public String getName() {
        return this.commandName;
    }

    /**
     * This method give the whole information about current program(its name and description)
     * @return command name and description of command
     */
    @Override
    public String toString() {
        return  commandName;
    }

    /**
     * The equals method compares the name and description of the command to the name and description of the other command
     * Value "true" would be returned only if name and description would be the same
     * @param o create an object to compare
     * @return the boolean value
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null) return false;
        if (getClass() != o.getClass()) return false;
        AbstractCommand other = (AbstractCommand) o;
        return commandName.equals(other.commandName) && description.equals(other.description);
    }

    /**
     * The hashCode method returns a hash code for the object
     * @return The hash code of the name and description
     */
    @Override
    public int hashCode() {
        return Objects.hash(commandName, description);
    }
}
