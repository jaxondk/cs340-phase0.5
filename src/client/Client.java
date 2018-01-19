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

        String test = "  go BYU ";
        System.out.println("Input string: "+test);
        String result = proxyNoCmd.toLC(test);
        System.out.println("ToLC result: "+result);
        result = proxyNoCmd.trim(test);
        System.out.println("trim result: "+result);
        result = proxyNoCmd.parseInt(test);
        System.out.println("parseInt result: "+result);
        test = "-12";
        System.out.println("----------New input string----------");
        System.out.println("Input string: "+test);
        result = proxyNoCmd.trim(test);
        System.out.println("parseInt result: "+result);
    }
}
