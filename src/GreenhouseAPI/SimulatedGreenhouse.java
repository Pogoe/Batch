package GreenhouseAPI;

import java.util.BitSet;

public class SimulatedGreenhouse implements IGreenhouse
{
    private double temp;
    private int moist;
    private int redLight;
    private int blueLight;
    private int fanSpeed;
    private int waterLevel;
    
    @Override
    public boolean SetTemperature(int kelvin)
    {
        temp = kelvin;
        return true;
    }

    @Override
    public boolean SetMoisture(int moist)
    {
        this.moist = moist;
        return true;
    }

    @Override
    public boolean SetRedLight(int level)
    {
        if(!(level > 100 || level < 0))
        {
            redLight = level;
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
        if(!(level > 100 || level < 0))
        {
            blueLight = level;
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
        if(!((waterLevel + sec) > 30))
        {
            waterLevel += sec;
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
        return temp;
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
        if(!(speed < 0 || speed > 2))
        {
            fanSpeed = speed;
            return true;
        }
        else
        {
            return false;
        }
    }
}