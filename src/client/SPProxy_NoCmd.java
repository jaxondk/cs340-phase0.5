package client;

import shared.IStringProcessor;

/**
 * Created by jaxon on 1/16/18.
 * Singleton.
 */
public class SPProxy_NoCmd implements IStringProcessor {
    private static SPProxy_NoCmd _proxy = new SPProxy_NoCmd();
    private SPProxy_NoCmd(){}
    public static SPProxy_NoCmd Instance()
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
