package server.handlers;

import server.StringProcessor;
import shared.Request;
import shared.Results;

/**
 * Created by jaxon on 1/17/18.
 */
public class CommandHandler extends Handler
{
    private static StringProcessor _sp = StringProcessor.Instance();
    public Results process(Request request)
    {
        Results results = new Results();
        results.setData(_sp.toLC(request.getText()));
        results.setSuccess(true);
        return results;
    }
}
