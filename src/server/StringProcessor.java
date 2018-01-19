package server;

import shared.IStringProcessor;

/**
 * Created by jaxon on 1/17/18.
 */
public class StringProcessor implements IStringProcessor {
    private static StringProcessor _sp = new StringProcessor();
    private StringProcessor(){}
    public static StringProcessor Instance()
    {
        return _sp;
    }

    public String toLC(String s)
    {
        return s.toLowerCase();
    }

    public String trim(String s)
    {
        return s.trim();
    }

    public String parseInt(String s) throws NumberFormatException
    {
        return ""+Integer.parseInt(s);
    }
}
