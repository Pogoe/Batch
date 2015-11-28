package controller;

import GreenhouseAPI.Greenhouse;
import GreenhouseAPI.IGreenhouse;
import batchserver.IBatchExporter;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Map;
import plccommunication.PLCConnection;
import plccommunication.UDPConnection;

public class BatchController
{
    protected static IBatchReciever server;
    private IBatchExporter client;
    protected static IGreenhouse greenhouse;
    private static BatchController instance;
    
    private int capacity = 3000;
    private Map<String, Integer> order;
    private int currentCapacity;
    private int removedUnits;
    private boolean executing;
    
    public static BatchController get()
    {
        if(instance == null)
        {
            instance = new BatchController();
        }
        return instance;
    }
    
    public void connect()
    {
        try
        {
            PLCConnection conn = new UDPConnection(5000, "192.168.0.10");
            greenhouse = new Greenhouse(conn);
            server = (IBatchReciever) LocateRegistry.getRegistry("localhost", 7000).lookup("SCADA");
            server.connectToServer(client);
        } catch(AccessException ex)
        {
            System.err.println("Unable to bind object: " + ex);
        }
        catch (RemoteException ex)
        {
            System.err.println("Remote communication error: " + ex);
        } catch (NotBoundException ex)
        {
            System.err.println("Unable to bind object: " + ex);
        }
    }
    
    public IGreenhouse getGreenhouse()
    {
        return greenhouse;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public Map<String, Integer> getOrder()
    {
        return order;
    }
    
    public void startOrder(Map<String, Integer> order)
    {
        this.order = order;
        executing = true;
    }

    public int getCurrentCapacity()
    {
        return currentCapacity;
    }

    public int getRemovedUnits()
    {
        return removedUnits;
    }
    
    public boolean isExecuting()
    {
        return executing;
    }
}
