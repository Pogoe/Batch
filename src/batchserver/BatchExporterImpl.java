package batchserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public class BatchExporterImpl extends UnicastRemoteObject implements IBatchExporter
{
    private int capacity = 3000;
    private String name;
    private Map<String, Integer> order;
    private int currentCapacity;
    private int removedUnits;
    
    public BatchExporterImpl(String name) throws RemoteException
    {
        this.name = name;
    }
    @Override
    public void startOrder(Map<String, Integer> order) throws RemoteException
    {
        this.order = order;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTemp(double temp) throws RemoteException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addMoist(int level) throws RemoteException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addWater(int sec) throws RemoteException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRedLight(int level) throws RemoteException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBlueLight(int level) throws RemoteException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFanSpeed(int level) throws RemoteException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isExecuting() throws RemoteException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCapacity() throws RemoteException
    {
        return capacity;
    }
    
    @Override
    public String getName()
    {
        return name;
    }
    
    @Override
    public Map<String, Integer> getCurrentOrder()
    {
        return order;
    }
    
    @Override
    public int getCurrentCapacity()
    {
        return currentCapacity;
    }
    
    @Override
    public int getRemovedUnits()
    {
        return removedUnits;
    }
}
