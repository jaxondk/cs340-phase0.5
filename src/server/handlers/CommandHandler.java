package server.handlers;

import shared.ICommand;
import shared.Request;
import shared.Results;

/**
 * Created by jaxon on 1/17/18.
 */
public class CommandHandler extends Handler
{
    public Results process(Request request)
    {
        ICommand c = request.getCommand();
        return c.execute();
    }
}
