package wsservers;

import javax.jws.WebService;

@WebService(endpointInterface = "wsservers.ISCADAServer")
public class SCADAServerImpl implements ISCADAServer
{
    @Override
    public void setTemperature(int kelvin)
    {
        
    }

    @Override
    public void setMoisture(int level)
    {
        
    }

    @Override
    public void setRedLight(int level)
    {
        
    }

    @Override
    public void setBlueLight(int level)
    {
        
    }

    @Override
    public void addWater(int sec)
    {
        
    }

    @Override
    public void addFertilizer(int sec)
    {
        
    }

    @Override
    public void addCO2(int sec)
    {
        
    }
}
