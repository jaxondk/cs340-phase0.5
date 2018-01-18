package server.handlers;

import shared.Request;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import shared.Results;
import shared.StreamUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/**
 * Created by jaxon on 1/17/18.
 *
 * This should implement some functionality that is common between all the handlers
 * TODO - identify what this common functionality is.
 * See https://students.cs.byu.edu/~cs340ta/winter2018/notes/05-Web-API-Implementation/sampleUML.pdf
 */
public class Handler
{
    private static Gson gson = new Gson();

    // Deserialize the JSON string from the HTTP request body into an object
    public Request deserializeReqBody(HttpExchange exchange) throws IOException
    {
        InputStream reqBody = exchange.getRequestBody();
        String json = StreamUtil.readString(reqBody);
        return gson.fromJson(json, Request.class);
    }

    public void sendResp(HttpExchange exchange, Results results) throws IOException
    {
        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
        OutputStream respBodyOS = exchange.getResponseBody();
        StreamUtil.writeString(gson.toJson(results), respBodyOS);
        respBodyOS.close();
    }
}
