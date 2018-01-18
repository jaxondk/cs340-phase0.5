package shared;

import java.lang.reflect.Method;

/**
 * Created by jaxon on 1/17/18.
 */
public class Command implements ICommand {
    private String _className;
    private String _methodName;
    private Class<?>[] _paramTypes;
    private Object[] _paramValues;

    public Command(String className, String methodName,
                          Class<?>[] paramTypes, Object[] paramValues) {
        _className = className;
        _methodName = methodName;
        _paramTypes = paramTypes;
        _paramValues = paramValues;
    }

    @Override
    public void execute() {
        try {
            Class<?> ReceiverClass = Class.forName(_className);
            Method method = ReceiverClass.getMethod(_methodName, _paramTypes);
            method.invoke(null, _paramValues);
            //TODO: needs some work. This implementation assumes the method being invoked is a static method
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
