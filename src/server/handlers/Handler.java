package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * Created by jaxon on 1/17/18.
 *
 * This should implement some functionality that is common between all the handlers
 * TODO - identify what this common functionality is.
 * See https://students.cs.byu.edu/~cs340ta/winter2018/notes/05-Web-API-Implementation/sampleUML.pdf
 */
public class Handler implements HttpHandler
{
    public void handle(HttpExchange exchange)
    {

    }

    public String readReqBody(HttpExchange exchange)
    {
        return null;
    }

    public void sendResp(HttpExchange exchange) //TODO, also says to have results object here.
    {

    }
}
