package batchserver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server
{
    public static final int PORT = 8000;
    public static final String NAME = "Batch";
    
    public static void main(String[] args)
    {
        try
        {
            LocateRegistry.createRegistry(PORT).bind(NAME, new BatchExporterImpl());
        } catch (RemoteException ex)
        {
            System.err.println("Remote communication error: " + ex);
        } catch (AlreadyBoundException ex)
        {
            System.err.println("Unable to bind object: " + ex);
        }
    }
}
