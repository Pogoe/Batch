package GreenhouseAPI;

import java.util.BitSet;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.Observable;

public class SimulatedGreenhouse extends Observable implements IGreenhouse
{
    private DoubleAdder temp = new DoubleAdder();
    private int moist;
    private int redLight;
    private int blueLight;
    private int fanSpeed;
    private int waterLevel;

    private double tref = 10;
    private double tu = 5;
    private double rres = 0.5;
    private double c = 20;
    private double tau = c / rres;
    private double dTdt;
    private double delta = 1;
    private int p = 35;

    public void simulate()
    {
        new Thread(() ->
        {
            while (true)
            {
                dTdt = (p * rres + tu - temp.doubleValue()) / tau;
                temp.add((temp.doubleValue() + dTdt * delta) - temp.doubleValue());
                synchronized (this)
                {
                    try
                    {
                        this.wait((long) delta * 1000);
                    } catch (InterruptedException ex)
                    {
                        System.err.println(ex);
                    }
                }
                setChanged();
                notifyObservers();
                
                if (temp.doubleValue() > tref)
                {
                    p = 0;
                }
                else
                {
                    p = 35;
                }
            }

        }).start();
    }

    @Override
    public boolean SetTemperature(int kelvin)
    {
        temp.add(kelvin - temp.doubleValue());
        notifyObservers();
        return true;
    }

    @Override
    public boolean SetMoisture(int moist)
    {
        this.moist = moist;
        notifyObservers();
        return true;
    }

    @Override
    public boolean SetRedLight(int level)
    {
        if (!(level > 100 || level < 0))
        {
            redLight = level;
            notifyObservers();
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean SetBlueLight(int level)
    {
        if (!(level > 100 || level < 0))
        {
            blueLight = level;
            notifyObservers();
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean AddWater(int sec)
    {
        if (!((waterLevel + sec) > 30))
        {
            waterLevel += sec;
            notifyObservers();
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean AddFertiliser(int sec)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean AddCO2(int sec)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double ReadTemp1()
    {
        return temp.doubleValue();
    }

    @Override
    public double ReadTemp2()
    {
        return 20.3;
    }

    @Override
    public double ReadMoist()
    {
        return moist;
    }

    @Override
    public double ReadWaterLevel()
    {
        return waterLevel;
    }

    @Override
    public double ReadPlantHeight()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BitSet ReadErrors()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ResetError(int errorNum)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public byte[] GetStatus()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean SetFanSpeed(int speed)
    {
        if (!(speed < 0 || speed > 2))
        {
            fanSpeed = speed;
            notifyObservers();
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public int getRedLight()
    {
        return redLight;
    }

    @Override
    public int getBlueLight()
    {
        return blueLight;
    }
}
