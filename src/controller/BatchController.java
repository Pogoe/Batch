/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import plccommunication.*;
import GreenHouseAPI.*;
import java.util.BitSet;

/**
 *
 * @author jacqueskwizera
 */
public class BatchController implements iBatchController
{

    PLCConnection con = new UDPConnection(5000, "192.168.0.10");
    IGreenhouse api = new Greenhouse(con);

    public double getTemp1()
    {
        return api.ReadTemp1();
    }

    public double getTemp2()
    {
        return api.ReadTemp2();

    }

    public double getMoist()
    {
        return api.ReadMoist();
    }

    public double getWaterLevel()
    {
        return api.ReadWaterLevel();
    }

    public BitSet getErros()
    {
        BitSet bitSet = api.ReadErrors();
        //TODO: Konverter bitset til Error besked/klasse.
        return bitSet;
    }

    public void setTemp(int kelvin)
    {
        api.SetTemperature(kelvin);
    }

    public void setMoist(int moist)
    {
        api.SetMoisture(moist);
    }

    public void addWater(int sec)
    {
        api.AddWater(sec);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
    }

}
