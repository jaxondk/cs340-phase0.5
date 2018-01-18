package server;

import shared.IStringProcessor;

/**
 * Created by jaxon on 1/17/18.
 */
public class StringProcessor implements IStringProcessor {
    private static StringProcessor _sp = new StringProcessor();
    private StringProcessor(){}
    public StringProcessor Instance()
    {
        return _sp;
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
