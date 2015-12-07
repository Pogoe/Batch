package batchserver;

import controller.BatchController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public class BatchExporterImpl extends UnicastRemoteObject implements IBatchExporter
{
    private BatchController controller = new BatchController();
    private String name;
    
    public BatchExporterImpl(String name) throws RemoteException
    {
        this.name = name;
    }
    @Override
    public void startOrder(Map<String, Integer> order) throws RemoteException
    {
        controller.startOrder(order);
    }

    @Override
    public void setTemp(int temp) throws RemoteException
    {
        controller.getGreenhouse().SetTemperature(temp);
    }

    @Override
    public void addMoist(int level) throws RemoteException
    {
        controller.getGreenhouse().SetMoisture(level);
    }

    @Override
    public void addWater(int sec) throws RemoteException
    {
        controller.getGreenhouse().AddWater(sec);
    }

    @Override
    public void setRedLight(int level) throws RemoteException
    {
        controller.getGreenhouse().SetRedLight(level);
    }

    @Override
    public void setBlueLight(int level) throws RemoteException
    {
        controller.getGreenhouse().SetBlueLight(level);
    }

    @Override
    public void setFanSpeed(int level) throws RemoteException
    {
        controller.getGreenhouse().SetFanSpeed(level);
    }

    @Override
    public boolean isExecuting() throws RemoteException
    {
        return controller.isExecuting();
    }

    @Override
    public int getCapacity() throws RemoteException
    {
        return controller.getCapacity();
    }
    
    @Override
    public String getName()
    {
        return name;
    }
    
    @Override
    public Map<String, Integer> getCurrentOrder()
    {
        return controller.getOrder();
    }
    
    @Override
    public int getCurrentCapacity()
    {
        return controller.getCurrentCapacity();
    }
    
    @Override
    public int getRemovedUnits()
    {
        return controller.getRemovedUnits();
    }

    @Override
    public BatchController getController()
    {
        return controller;
    }
}
