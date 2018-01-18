package client;

import shared.IStringProcessor;
import shared.Request;
import shared.Results;

/**
 * Created by jaxon on 1/16/18.
 * Singleton.
 */
public class SPProxy_NoCmd implements IStringProcessor {
    private static SPProxy_NoCmd _proxy;
    private ClientComm clientComm;

    private SPProxy_NoCmd(String serverHost, String serverPort)
    {
        clientComm = new ClientComm(serverHost, serverPort);
    }

    //TODO - i don't want to hard code host and port into clientComm, but i don't like requiring Instance() to take params either. Find better way
    public static SPProxy_NoCmd Instance(String serverHost, String serverPort)
    {
        if(_proxy == null)
            _proxy = new SPProxy_NoCmd(serverHost, serverPort);
        return _proxy;
    }

    public String toLC(String s)
    {
        Request request = new Request(s, null);
        Results results = clientComm.sendAndRecv("/toLC", request);
        if(results.isSuccess())
            return results.getData();
        else
            return results.getErrorInfo();
    }

    public String trim(String s)
    {
        return null;
    }

    public String parseInt(String s)
    {
        return null;
    }
}
