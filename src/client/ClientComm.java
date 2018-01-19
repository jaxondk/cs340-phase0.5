package client;

import com.google.gson.Gson;
import shared.Request;
import shared.Results;
import shared.StreamUtil;

import java.io.*;
import java.net.*;

/**
 * Created by jaxon on 1/17/18.
 */
public class ClientComm
{
    private String _host, _port;
    private static Gson gson = new Gson();

    public ClientComm(String serverHost, String serverPort)
    {
        _host = serverHost;
        _port = serverPort;
    }

    //TODO - Need to make this work with Command objects. How do you send objects? EDIT: should work as is now
    public Results sendAndRecv(String urlPath, Request request)
    {
        Results results = null;
        try {
            URL url = new URL("http://" + _host + ":" + _port + urlPath);

            // Start constructing our HTTP request
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);	// There is a request body

            // Connect to the server, opening the socket and ready to send bytes
            http.connect();

            OutputStream reqBodyOS = http.getOutputStream(); // Get the output stream containing the HTTP request body
            StreamUtil.writeString(gson.toJson(request), reqBodyOS);

            reqBodyOS.close(); //send bytes

            // By the time we get here, the HTTP response has been received from the server.
            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream respBodyIS = http.getInputStream();
                String respJson = StreamUtil.readString(respBodyIS);
                results = gson.fromJson(respJson, Results.class);
            }
            else {
                System.out.println("ERROR: " + http.getResponseMessage());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

}
