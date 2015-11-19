package data;

import java.util.Date;

public class BatchError
{
    private int id;
    private String name;
    private String details;
    private ErrorTypes type;
    private Date created;
    private Date stored;
    private double value;
    private String host;
    private String comments;
    
    public BatchError(ErrorTypes type, double value, String host)
    {
        this.type = type;
        this.value = value;
        this.host = host;
        this.created = new Date();
    }
    
    public BatchError(int id, String name, String details, String comments, Date created, Date stored)
    {
        this.id = id;
        this.name = name;
        this.details = details;
        this.comments = comments;
        this.created = created;
        this.stored = stored;
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
