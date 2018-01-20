package client;

import shared.IStringProcessor;
import shared.Request;
import shared.Results;
import shared.SPCommand;

/**
 * Created by jaxon on 1/16/18.
 * Singleton.
 */
public class SPProxy_Cmd implements IStringProcessor {
    private static SPProxy_Cmd _proxy;
    private ClientComm clientComm;

    private SPProxy_Cmd(String serverHost, String serverPort)
    {
        clientComm = new ClientComm(serverHost, serverPort);
    }

    static SPProxy_Cmd Instance(String serverHost, String serverPort)
    {
        if(_proxy == null)
            _proxy = new SPProxy_Cmd(serverHost, serverPort);
        return _proxy;
    }

    public String toLC(String s)
    {
        SPCommand c = new SPCommand("toLC",s);
        Request request = new Request(s, c);
        Results results = clientComm.sendAndRecv("/command", request);
        return results.getAppropriateMessage();
    }

    public String trim(String s)
    {
        SPCommand c = new SPCommand("trim",s);
        Request request = new Request(s, c);
        Results results = clientComm.sendAndRecv("/command", request);
        return results.getAppropriateMessage();
    }

    public String parseInt(String s)
    {
        SPCommand c = new SPCommand("parseInt",s);
        Request request = new Request(s, c);
        Results results = clientComm.sendAndRecv("/command", request);
        return results.getAppropriateMessage();
    }
}
