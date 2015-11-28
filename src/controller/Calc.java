package controller;

import data.Meassure;
import data.MeassureTypes;
import java.rmi.RemoteException;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calc
{
    private BatchController controller = BatchController.get();

    public void meassureInsideTemp()
    {
        new Thread(() ->
        {
            DoubleAdder temp = new DoubleAdder();
            temp.add(BatchController.greenhouse.ReadTemp1());
            while (controller.isExecuting())
            {
                if(temp.doubleValue() == BatchController.greenhouse.ReadTemp1())
                {
                    temp.add(temp.doubleValue() - BatchController.greenhouse.ReadTemp1());
                    try
                    {
                        BatchController.server.sendTemp1(new Meassure(temp.doubleValue(), MeassureTypes.TEMPERATURE_INSIDE));
                    } catch (RemoteException ex)
                    {
                        Logger.getLogger(Calc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
    
    public void meassureOutsideTemp()
    {
        new Thread(() ->
        {
            DoubleAdder temp = new DoubleAdder();
            temp.add(BatchController.greenhouse.ReadTemp2());
            while (controller.isExecuting())
            {
                if(temp.doubleValue() == BatchController.greenhouse.ReadTemp2())
                {
                    temp.add(temp.doubleValue() - BatchController.greenhouse.ReadTemp2());
                    try
                    {
                        BatchController.server.sendTemp2(new Meassure(temp.doubleValue(), MeassureTypes.TEMPERATURE_OUTSIDE));
                    } catch (RemoteException ex)
                    {
                        Logger.getLogger(Calc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
    
    public void meassureWaterLevel()
    {
        new Thread(() ->
        {
            DoubleAdder level = new DoubleAdder();
            level.add(BatchController.greenhouse.ReadWaterLevel());
            while (controller.isExecuting())
            {
                if(level.doubleValue() == BatchController.greenhouse.ReadTemp2())
                {
                    level.add(level.doubleValue() - BatchController.greenhouse.ReadTemp2());
                    try
                    {
                        BatchController.server.sendWaterLevel(new Meassure(level.doubleValue(), MeassureTypes.WATER_LEVEL));
                    } catch (RemoteException ex)
                    {
                        Logger.getLogger(Calc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
    
    public void meassureMoist()
    {
        new Thread(() ->
        {
            DoubleAdder level = new DoubleAdder();
            level.add(BatchController.greenhouse.ReadMoist());
            while (controller.isExecuting())
            {
                if(level.doubleValue() == BatchController.greenhouse.ReadTemp2())
                {
                    level.add(level.doubleValue() - BatchController.greenhouse.ReadTemp2());
                    try
                    {
                        BatchController.server.sendMoist(new Meassure(level.doubleValue(), MeassureTypes.MOISTURE));
                    } catch (RemoteException ex)
                    {
                        Logger.getLogger(Calc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
    
    public void meassureErrors()
    {
        new Thread(() -> 
        {
            while (controller.isExecuting())
            {
                //Do something about the errors
            }
        }).start();
    }
}
