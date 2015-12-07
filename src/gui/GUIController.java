package gui;

import controller.BatchController;
import java.net.URL;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorInput;
import javafx.scene.paint.Color;


public class GUIController implements Observer, Initializable
{

    @FXML
    private Tab startTab, temperatureTab, humidityWaterTab;
    @FXML
    private Label temperaturLabel, humidityLabel, waterLevelLabel, lightLabel;
    @FXML
    private TextField tempTextField, humidityTextField, waterLevelTextField,
            lightTextField;
    @FXML
    private LineChart<?, ?> tempChart;

    private BatchController controller;
    private ObservableList<Data> obTemps = FXCollections.observableArrayList();
    private ObservableList<Data> obMoist = FXCollections.observableArrayList();
    private Series temps = new Series(obTemps);
    private Series moists = new Series(obMoist);
    @FXML
    private LineChart<?, ?> lineChartPane;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        controller = new BatchController();
        controller.connect();
        controller.getGreenhouse().addObserver(this);
    }

    public void updateValues()
    {
        tempTextField.setText(String.valueOf(controller.getGreenhouse().ReadTemp1()));
        humidityTextField.setText(String.valueOf(controller.getGreenhouse().ReadMoist()));
        lightTextField.setEffect(new ColorInput(lightTextField.getLayoutX(),
                lightTextField.getLayoutY(),
                lightTextField.getWidth(),
                lightTextField.getHeight(),
                new Color(controller.getGreenhouse().getRedLight() / 100, 0.0, controller.getGreenhouse().getBlueLight() / 100, 0.0)));
        waterLevelTextField.setText(String.valueOf(controller.getGreenhouse().ReadWaterLevel()));
        updateTempChart(controller.getGreenhouse().ReadTemp1(), new Date());
        updateMoistChart(controller.getGreenhouse().ReadMoist(), new Date());
    }

    public void updateTempChart(double level, Date time)
    {
        new Thread(() ->
        {
            obTemps.add(new Data(level, time));
            if (obTemps.size() < 10)
            {
                obTemps.remove(0);
            }
        }).start();
    }

    public void updateMoistChart(double level, Date time)
    {
        new Thread(() ->
        {
            obMoist.add(new Data(level, time));
            if (obMoist.size() < 10)
            {
                obMoist.remove(0);
            }
        }).start();
    }

    @Override
    public void update(Observable o, Object o1)
    {
        updateValues();
        controller.update();
    }
}
