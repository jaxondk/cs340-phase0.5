package client;

import shared.Results;
import java.io.*;
import java.net.*;

/**
 * Created by jaxon on 1/17/18.
 */
public class ClientComm
{
    private String _host, _port;

    public ClientComm(String serverHost, String serverPort)
    {
        _host = serverHost;
        _port = serverPort;
    }

    //POST
    //TODO - Need to make this work with Command objects. How do you send objects?
    public Results send(String urlPath, String reqInfo)
    {
        Results r;
        try {
            URL url = new URL("http://" + _host + ":" + _port + urlPath);

            // Start constructing our HTTP request
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);	// There is a request body

            // Connect to the server and send the HTTP request
            http.connect();

            // Get the output stream containing the HTTP request body
            OutputStream reqBody = http.getOutputStream();
            // Write the JSON data to the request body
            writeString(reqInfo, reqBody);
            // Close the request body output stream, indicating that the
            // request is complete
            reqBody.close();

            // By the time we get here, the HTTP response has been received from the server.
            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                System.out.println("HTTP response code successful");
                // Get the input stream containing the HTTP response body
                InputStream respBody = http.getInputStream();
                // Extract JSON data from the HTTP response body
                String respData = readString(respBody);
                // Display the JSON data returned from the server
                System.out.println(respData);
            }
            else {
                // The HTTP response status code indicates an error
                // occurred, so print out the message from the HTTP response
                System.out.println("ERROR: " + http.getResponseMessage());
            }
        }
        catch (IOException e) {
            // An exception was thrown, so display the exception's stack trace
            e.printStackTrace();
        }
        return null;
    }

    /*
		The readString method shows how to read a String from an InputStream.
	*/
    private static String readString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStreamReader sr = new InputStreamReader(is);
        char[] buf = new char[1024];
        int len;
        while ((len = sr.read(buf)) > 0) {
            sb.append(buf, 0, len);
        }
        return sb.toString();
    }

    /*
        The writeString method shows how to write a String to an OutputStream.
    */
    private static void writeString(String str, OutputStream os) throws IOException {
        OutputStreamWriter sw = new OutputStreamWriter(os);
        sw.write(str);
        sw.flush();
    }

}
