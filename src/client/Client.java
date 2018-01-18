package client;

/**
 * Created by jaxon on 1/16/18.
 *
 * Runs the various StringProcessor commands. Use this for pass off.
 * TODO - instead, just make jUnit tests.
 *
 */
public class Client
{

    public static void main(String[] args)
    {
        SPProxy_NoCmd proxyNoCmd = SPProxy_NoCmd.Instance("localhost", "8080");
        String test = "go BYU";
        String result = proxyNoCmd.toLC(test);
        System.out.println("Input string: "+test);
        System.out.println("ToLC Result: "+result);
    }
}
