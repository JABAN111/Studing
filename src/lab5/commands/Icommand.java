package lab5.commands;

import java.io.IOException;

/**
 * Interface for each command that extends AbstractCommand
 */
public interface Icommand {
    public String getDescription();
    public String getName();
    public void execute(String[] arg) throws IOException;
}
