package data;

import java.util.Date;

public class BatchError
{
    private ErrorTypes type;
    private Date created;
    private double value;
    private String host;
    
    public BatchError(ErrorTypes type, double value, String host)
    {
        this.type = type;
        this.value = value;
        this.host = host;
        this.created = new Date();
    }
    
    public ErrorTypes getError()
    {
        return type;
    }
    
    public double getValue()
    {
        return value;
    }
    
    public String getHost()
    {
        return host;
    }
}
