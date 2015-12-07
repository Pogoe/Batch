package batchserver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import javax.swing.JOptionPane;

public class Server
{
    public static final int PORT = 8000;
    public static final String NAME = "Batch";
    
    public static void startServer()
    {
        try
        {
            String s = JOptionPane.showInputDialog("Please provide a name for the batch controller", "Batch1");
            LocateRegistry.createRegistry(PORT).bind(NAME, new BatchExporterImpl(s));
        } catch (RemoteException ex)
        {
            System.err.println("Remote communication error: " + ex);
        } catch (AlreadyBoundException ex)
        {
            System.err.println("Unable to bind object: " + ex);
        }
    }
}
