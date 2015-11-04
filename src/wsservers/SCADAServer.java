package wsservers;

import javax.xml.ws.Endpoint;

public class SCADAServer
{
    public static final int PORT = 8002;
    public static final String NAME = "SCADA";
    public static final String WSURL = "http://localhost:" + PORT + "/ws/" + NAME;
    
    public static void main(String[] args)
    {
        Endpoint.publish(WSURL, new SCADAServerImpl());
        System.out.println("SCADA server is running on port " + PORT);
        System.out.println("WSDL avaiable at " + WSURL + "?wsdl");
    }
}
