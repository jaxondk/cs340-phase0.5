package shared;

/**
 * Created by jaxon on 1/17/18.
 */
public class Results
{
    public Results() {}

    private boolean success;
    private String data;
    private String errorInfo;

    public String getAppropriateMessage()
    {
        return success ? data : errorInfo;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public String getErrorInfo()
    {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo)
    {
        this.errorInfo = errorInfo;
    }
}
