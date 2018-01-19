package server.handlers;

import com.sun.net.httpserver.HttpHandler;
import server.StringProcessor;
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
 * Abstract base class for the handlers. Each handler needs to implement the abstract "process" method
 */
abstract class Handler implements HttpHandler
{
    private static Gson _gson = new Gson();

    @Override
    public void handle(HttpExchange exchange) throws IOException
    {
        boolean success = false;

        try {
            if (exchange.getRequestMethod().toLowerCase().equals("post"))
            {
                Request request = deserializeReqBody(exchange);
                System.out.println("Request text: "+request.getText());
                Results results = process(request);
                System.out.println("Results data: "+results.getData());
                sendResp(exchange, results);

                success = true;
            }

            if (!success) {
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
                exchange.getResponseBody().close();
            }
        }
        catch (IOException e) {
            // Some kind of internal error has occurred inside the server (not the
            // client's fault), so we return an "internal server error" status code
            // to the client.
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_SERVER_ERROR, 0);
            // We are not sending a response body, so close the response body
            // output stream, indicating that the response is complete.
            exchange.getResponseBody().close(); //todo - might want to send back a results object here with the error info?

            // Display/log the stack trace
            e.printStackTrace();
        }
    }

    abstract Results process(Request request);


    // Deserialize the JSON string from the HTTP request body into an object
    private Request deserializeReqBody(HttpExchange exchange) throws IOException
    {
        InputStream reqBody = exchange.getRequestBody();
        String json = StreamUtil.readString(reqBody);
        return _gson.fromJson(json, Request.class);
    }

    private void sendResp(HttpExchange exchange, Results results) throws IOException
    {
        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
        OutputStream respBodyOS = exchange.getResponseBody();
        StreamUtil.writeString(_gson.toJson(results), respBodyOS);
        respBodyOS.close();
    }
}
