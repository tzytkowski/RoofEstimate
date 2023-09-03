package roofestimatecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;


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
    private TextField wasteRemovalCostInput;

    
    @FXML
    public void calculateButtonClicked(ActionEvent event) {
        double length = Double.parseDouble(roofLengthInput.getText());
        double width = Double.parseDouble(roofWidthInput.getText());
        double area = length * width;
        roofAreaInput.setText(String.format("%.1f ft", area));

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
    double highTotalCost = (materialCost + laborCost + wasteRemovalCost + 1000);
    highTotalCostInput.setText(formatCurrency(highTotalCost));
    double lowTotalCost = (materialCost + laborCost + wasteRemovalCost - 1000);
    lowTotalCostInput.setText(formatCurrency(lowTotalCost));    
    }
    
    private String formatCurrency(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("$#,##0.00");
        return decimalFormat.format(value);
    }
    private void clearResults() {
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
