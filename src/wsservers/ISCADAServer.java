package wsservers;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ISCADAServer
{
    @WebMethod void setTemperature(int kelvin);
    @WebMethod void setMoisture(int level);
    @WebMethod void setRedLight(int level);
    @WebMethod void setBlueLight(int level);
    @WebMethod void addWater(int sec);
    @WebMethod void addFertilizer(int sec);
    @WebMethod void addCO2(int sec);
}
