package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

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
    private LineChart<?, ?> lineChartPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }
}
