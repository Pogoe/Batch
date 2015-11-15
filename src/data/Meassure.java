package data;

import java.sql.Timestamp;
import java.util.Date;

public class Meassure
{
    private double value;
    private MeassureTypes type;
    private Date time;
    
    public Meassure(double value, MeassureTypes type)
    {
        this.time = new Date();
        this.value = value;
        this.type = type;
    }
    
    public double getValue()
    {
        return value;
    }
    
    public MeassureTypes getType()
    {
        return type;
    }
    
    public Date getTime()
    {
        return time;
    }
    
    public Timestamp getTimestamp()
    {
        return new Timestamp(time.getTime());
    }
}
