package controller;

import batchserver.IBatchExporter;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class BatchController
{
    private IBatchReciever server;
    private IBatchExporter greenhouse;
    
    public void connect()
    {
        try
        {
            server = (IBatchReciever) LocateRegistry.getRegistry("localhost", 7000).lookup("SCADA");
            server.connectToServer(greenhouse);
        } catch (RemoteException ex)
        {
            System.err.println("Remote communication error: " + ex);
        } catch (NotBoundException ex)
        {
            System.err.println("Unable to bind object: " + ex);
        }
    }
}
