package server.handlers;

import server.StringProcessor;
import shared.Request;
import shared.Results;


/**
 * Created by jaxon on 1/17/18.
 */
public class parseIntHandler extends Handler
{
    private static StringProcessor _sp = StringProcessor.Instance();
    public Results process(Request request)
    {
        Results results = new Results();
        try
        {
            results.setData(_sp.parseInt(request.getText()));
            results.setSuccess(true);
        }
        catch (NumberFormatException e)
        {
            results.setErrorInfo(e.toString());
            results.setSuccess(false);
        }
        return results;
    }
}
