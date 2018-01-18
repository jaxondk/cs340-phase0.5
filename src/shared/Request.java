package shared;

import shared.Command;

/**
 * Created by jaxon on 1/17/18.
 *
 * A request object
 * If command is null, then we know the request body should consist of the text
 */
public class Request
{
    Command command;
    String text;

    public Request(String text, Command command)
    {
        this.text = text;
        this.command = command;
    }

    public Command getCommand()
    {
        return command;
    }

    public String getText()
    {
        return text;
    }
}
