package controller;

import GreenhouseAPI.Greenhouse;
import GreenhouseAPI.IGreenhouse;
import GreenhouseAPI.SimulatedGreenhouse;
import batchserver.BatchExporterImpl;
import batchserver.IBatchExporter;
import batchserver.Server;
import data.Meassure;
import data.MeassureTypes;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Map;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
        if (instance == null)
        {
            instance = new BatchController();
        }
        return instance;
    }

    public void connect()
    {
        String s = JOptionPane.showInputDialog("Please choose between simulated and physical greenhouse", "simulated");
        switch (s)
        {
            case "simulated":
                try
                {
                    Server.startServer();
                    client = new BatchExporterImpl("Batch1");
                    greenhouse = new SimulatedGreenhouse();
                    server = (IBatchReciever) LocateRegistry.getRegistry("localhost", 7000).lookup("SCADA");
                    server.connectToServer(client);
                } catch (AccessException ex)
                {
                    System.err.println("Unable to bind object: " + ex);
                } catch (RemoteException ex)
                {
                    System.err.println("Remote communication error: " + ex);
                } catch (NotBoundException ex)
                {
                    System.err.println("Unable to bind object: " + ex);
                }
                break;
            case "physical":
                try
                {
                    Server.startServer();
                    client = new BatchExporterImpl("Batch1");
                    PLCConnection conn = new UDPConnection(5000, "192.168.0.10");
                    greenhouse = new Greenhouse(conn);
                    server = (IBatchReciever) LocateRegistry.getRegistry("localhost", 7000).lookup("SCADA");
                    server.connectToServer(client);
                } catch (AccessException ex)
                {
                    System.err.println("Unable to bind object: " + ex);
                } catch (RemoteException ex)
                {
                    System.err.println("Remote communication error: " + ex);
                } catch (NotBoundException ex)
                {
                    System.err.println("Unable to bind object: " + ex);
                }
                break;
            default:
                connect();
                break;
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

    public void update()
    {
        try
        {
            server.sendTemp1(new Meassure(greenhouse.ReadTemp1(), MeassureTypes.TEMPERATURE_INSIDE));
            server.sendMoist(new Meassure(greenhouse.ReadMoist(), MeassureTypes.MOISTURE));
            server.sendWaterLevel(new Meassure(greenhouse.ReadWaterLevel(), MeassureTypes.WATER_LEVEL));
        } catch (RemoteException ex)
        {
            Logger.getLogger(BatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}