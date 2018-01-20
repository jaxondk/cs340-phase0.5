package shared;

import java.lang.reflect.Method;

/**
 * Created by jaxon on 1/17/18.
 */
public class SPCommand implements ICommand {
    private final String _className = "server.StringProcessor";
    private String _methodName; //toLC, trim, or parseInt
    private String _paramValue;

    public SPCommand(String methodName, String paramValue) {
        _methodName = methodName;
        _paramValue = paramValue;
    }

    @Override
    public Results execute() {
        Results results = new Results();
        try {
            //get string processor class
            Class<?> ReceiverClass = Class.forName(_className);
            //get instance of stringProcessor (which is a singleton)
            Method instantiate = ReceiverClass.getMethod("Instance");
            Object sp = instantiate.invoke(null);
            //call whatever method they wanted on it
            Method method = ReceiverClass.getMethod(_methodName, String.class);
            results.setData((String)method.invoke(sp, _paramValue));
            results.setSuccess(true);
        }
        catch (Exception e) {
            results.setErrorInfo(e.getCause().toString());
            results.setSuccess(false);
        }

        return results;
    }
}
