package controller;

public interface iBatchController
{
    public double getTemp1();

    public double getTemp2();

    public double getMoist();

    public double getWaterLevel();

    public void setTemp(int kelvin);

    public void setMoist(int moist);

    public void addWater(int sec);
}
