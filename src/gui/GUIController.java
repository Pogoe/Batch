package gui;

import controller.BatchController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorInput;
import javafx.scene.paint.Color;

public class GUIController implements Initializable
{

    @FXML
    private Tab startTab, temperatureTab, humidityWaterTab;
    @FXML
    private Label temperaturLabel, humidityLabel, waterLevelLabel, lightLabel;
    @FXML
    private TextField tempTextField, humidityTextField, waterLevelTextField,
            lightTextField;
    @FXML
    private LineChart<?, ?> lineChartPane2;
    @FXML
    private LineChart<?, ?> tempChart;

    private BatchController controller;
    private Series temps = new Series();
    private ObservableList<Series> obTemps = FXCollections.observableArrayList(temps);
    private Series moist = new Series();
    private ObservableList<Series> obMoist = FXCollections.observableArrayList(moist);

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        controller = new BatchController();
        controller.connect();

        obTemps.addListener((ListChangeListener.Change<? extends Series> s) ->
        {
            tempChart.getData().add(temps);
        });
        obMoist.addListener((ListChangeListener.Change<? extends Series> s) ->
        {
            lineChartPane2.getData().add(moist);
        });
        updateValues();
    }
    
    public void updateValues()
    {
        tempTextField.setText(String.valueOf(controller.getGreenhouse().ReadTemp1()));
        humidityTextField.setText(String.valueOf(controller.getGreenhouse().ReadMoist()));
        lightTextField.setEffect(new ColorInput(lightTextField.getLayoutX(),
                lightTextField.getLayoutY(),
                lightTextField.getWidth(),
                lightTextField.getHeight(),
                new Color(0.0, 0.0, 0.0, 0.0)));
        waterLevelTextField.setText(String.valueOf(controller.getGreenhouse().ReadWaterLevel()));
    }
    
    public void updateCharts()
    {
        
    }
}
