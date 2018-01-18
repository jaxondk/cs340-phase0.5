package server.handlers;

import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;
import shared.Request;
import shared.Results;

/**
 * Created by jaxon on 1/17/18.
 */
public class toLCHandler extends Handler implements HttpHandler
{
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        boolean success = false;

        try {
            if (exchange.getRequestMethod().toLowerCase().equals("post"))
            {
                Request request = deserializeReqBody(exchange);

                System.out.println("Request text: "+request.getText());

                Results results = new Results();
                results.setData(request.getText().toLowerCase()); //TODO - could implement some error checking (say if request's text is blank)
                results.setSuccess(true);
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
}
