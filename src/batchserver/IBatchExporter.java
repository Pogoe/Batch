package batchserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface IBatchExporter extends Remote
{
    void startOrder(Map<String, Integer> order) throws RemoteException;
    void setTemp(double temp) throws RemoteException;
    void addMoist(int level) throws RemoteException;
    void addWater(int sec) throws RemoteException;
    void setRedLight(int level) throws RemoteException;
    void setBlueLight(int level) throws RemoteException;
    void setFanSpeed(int level) throws RemoteException;
    boolean isExecuting() throws RemoteException;
    int getCapacity() throws RemoteException;
    String getName() throws RemoteException;
    Map<String, Integer> getCurrentOrder() throws RemoteException;
    int getCurrentCapacity() throws RemoteException;
    int getRemovedUnits() throws RemoteException;
}
