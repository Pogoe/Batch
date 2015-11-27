package gui;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class GUIController
{
    @FXML
    private Tab startTab;
    @FXML
    private Label temperaturLabel;
    @FXML
    private Label humidityLabel;
    @FXML
    private Label waterLevelLabel;
    @FXML
    private Label lightLabel;
    @FXML
    private TextField tempTextField;
    @FXML
    private TextField humidityTextField;
    @FXML
    private TextField waterLevelTextField;
    @FXML
    private TextField lightTextField;
    @FXML
    private Tab temperatureTab;
    @FXML
    private LineChart<?, ?> lineChartPane2;
    @FXML
    private Tab humidityWaterTab;
    @FXML
    private LineChart<?, ?> lineChartPane;
    
}
