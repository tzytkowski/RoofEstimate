package roofestimatecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class RoofEstimateCalculatorController {

    @FXML
    private TextField highTotalCostInput;

    @FXML
    private TextField laborCostInput;

    @FXML
    private TextField lowTotalCostInput;

    @FXML
    private TextField materialCostInput;

    @FXML
    private Slider numberStoriesSlider;

    @FXML
    private TextField roofAreaInput;

    @FXML
    private TextField roofLengthInput;

    @FXML
    private Label roofLengthLabel;

    @FXML
    private Label roofPitchLabel;

    @FXML
    private TextField roofWidthInput;

    @FXML
    private Label roofWidthLabel;

    @FXML
    private Slider slopeSlider;

    @FXML
    private Label storiesLabel;

    @FXML
    private Button submitButton;

    @FXML
    private Button clear;

    @FXML
    private TextField wasteRemovalCostInput;

    @FXML
    public void calculateButtonClicked(ActionEvent event) {
        double length = Double.parseDouble(roofLengthInput.getText());
        double width = Double.parseDouble(roofWidthInput.getText());
        double area = length * width;
        roofAreaInput.setText(String.format("%.1f sq. ft", area));

        // Hypothetical cost values
        double costPerSqFt = 3.50;
        double laborCostPerSqFt = 2.00;
        double wasteRemovalCostPerSqFt = 0.50;
        double materialCost = costPerSqFt * area;
        double laborCost = laborCostPerSqFt * area;
        double wasteRemovalCost = wasteRemovalCostPerSqFt * area;

        calculateCosts(materialCost, laborCost, wasteRemovalCost);
    }

    private void calculateCosts(double materialCost, double laborCost, double wasteRemovalCost) {
        materialCostInput.setText(formatCurrency(materialCost));
        laborCostInput.setText(formatCurrency(laborCost));
        wasteRemovalCostInput.setText(formatCurrency(wasteRemovalCost));
        numberStoriesSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                numberStoriesSlider.setValue(newValue.doubleValue());
            }
            });
               
        slopeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                // Update the value of the slopeSlider control (if it's a Slider)
                slopeSlider.setValue(newValue.doubleValue());

                // Calculate roofSlope based on the new Slider value
                double roofSlope = newValue.doubleValue() * 0.10;

                // You can perform any actions you want here based on the new Slider value and roofSlope.
            }
        });
        
        double storiesSlope = (numberStoriesSlider.getValue() * slopeSlider.getValue());
        
        double highTotalCost = ((materialCost + laborCost + wasteRemovalCost + storiesSlope + 1000));
        highTotalCostInput.setText(formatCurrency(highTotalCost));
        double lowTotalCost = (materialCost + laborCost + wasteRemovalCost + storiesSlope - 1000);
        lowTotalCostInput.setText(formatCurrency(lowTotalCost));
    }

    private String formatCurrency(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("$#,##0");
        return decimalFormat.format(value);
    }

    public void clearResults(ActionEvent e) {
        // Clear or reset the input fields
        roofLengthInput.clear();
        roofWidthInput.clear();
        roofAreaInput.clear();
        materialCostInput.clear();
        laborCostInput.clear();
        wasteRemovalCostInput.clear();
        highTotalCostInput.clear();
        lowTotalCostInput.clear();

        // You can also reset the sliders or other UI elements if needed
        numberStoriesSlider.setValue(0);
        slopeSlider.setValue(0);
    }
}
