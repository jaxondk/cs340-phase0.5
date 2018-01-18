package client;

import shared.IStringProcessor;

/**
 * Created by jaxon on 1/16/18.
 * Singleton.
 */
public class SPProxy_Cmd implements IStringProcessor {
    private static SPProxy_Cmd _proxy = new SPProxy_Cmd();
    private SPProxy_Cmd(){}
    public SPProxy_Cmd Instance()
    {
        return _proxy;
    }

    public String toLC(String s)
    {
        return null;
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
