package shared;

/**
 * Created by jaxon on 1/17/18.
 *
 * A request object
 * If command is null, then we know the request body should consist of the text
 */
public class Request
{
    private SPCommand command;
    private String text;

    public Request(String text, SPCommand command)
    {
        this.text = text;
        this.command = command;
    }

    public SPCommand getCommand()
    {
        return command;
    }

    public String getText()
    {
        return text;
    }
}
