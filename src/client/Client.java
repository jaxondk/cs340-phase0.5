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
        String test, result;
        SPProxy_NoCmd proxyNoCmd = SPProxy_NoCmd.Instance("localhost", "8080");

        System.out.println("--------------------------------------NO COMMAND PROXY--------------------------------------");
        test = "  go BYU ";
        System.out.println("Input string: "+test);
        result = proxyNoCmd.toLC(test);
        System.out.println("-->ToLC result: "+result);
        result = proxyNoCmd.trim(test);
        System.out.println("-->trim result: "+result);
        result = proxyNoCmd.parseInt(test);
        System.out.println("-->parseInt result: "+result);
        test = "-12";
        System.out.println();
        System.out.println("Input string: "+test);
        result = proxyNoCmd.trim(test);
        System.out.println("-->parseInt result: "+result);

        System.out.println();
        System.out.println("----------------------------------------COMMAND PROXY----------------------------------------");
        SPProxy_Cmd proxyCmd = SPProxy_Cmd.Instance("localhost", "8080");
        test = "  go BYU ";
        System.out.println("Input string: "+test);
        result = proxyCmd.toLC(test);
        System.out.println("-->ToLC result: "+result);
        result = proxyCmd.trim(test);
        System.out.println("-->trim result: "+result);
        result = proxyCmd.parseInt(test);
        System.out.println("-->parseInt result: "+result);
        test = "-12";
        System.out.println();
        System.out.println("Input string: "+test);
        result = proxyCmd.trim(test);
        System.out.println("-->parseInt result: "+result);
    }
}
