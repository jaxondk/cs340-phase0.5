package server.handlers;

import server.StringProcessor;
import shared.Request;
import shared.Results;

/**
 * Created by jaxon on 1/17/18.
 */
public class trimHandler extends Handler
{
    private static StringProcessor _sp = StringProcessor.Instance();
    public Results process(Request request)
    {
        Results results = new Results();
        results.setData(_sp.trim(request.getText()));
        results.setSuccess(true);
        return results;
    }
}
