package roofestimatecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RoofEstimateCalculatorController {

    @FXML
    private TextField roofAreaInput;
    @FXML
    private TextField roofLengthInput;
    @FXML
    private TextField roofWidthInput;
    /*
    @FXML
    private Slider numberStoriesSlider;0
*/
    @FXML
    private TextField wasteRemovalCostInput;
    @FXML
    private TextField laborCostInput;
    @FXML
    private TextField materialCostInput;
    @FXML 
    private TextField highTotalCostInput;
    @FXML 
    private TextField lowTotalCostInput;
    
    @FXML
    void calculateButtonClicked(ActionEvent event) {
        double length = Double.parseDouble(roofLengthInput.getText());
        double width = Double.parseDouble(roofWidthInput.getText());
        double area = length * width;
        roofAreaInput.setText(String.valueOf(area));

        // Hypothetical cost values
        double costPerSqFt = 3.50;
        double laborCostPerSqFt = 2.00;
        double wasteRemovalCostPerSqFt = 0.50;

        // Calculate costs
        double materialCost = costPerSqFt * area;
        double laborCost = laborCostPerSqFt * area;
        double wasteRemovalCost = wasteRemovalCostPerSqFt * area;
        double highTotalCost = materialCost + laborCost + wasteRemovalCost  + 1000;
        double lowTotalCost = materialCost + laborCost + wasteRemovalCost  + 1000;

        // Display or use the calculated costs
        materialCostInput.setText(String.valueOf(materialCost));
        laborCostInput.setText(String.valueOf(laborCost));
        wasteRemovalCostInput.setText(String.valueOf(wasteRemovalCost));
        lowTotalCostInput.setText(String.valueOf(lowTotalCost));
        highTotalCostInput.setText(String.valueOf(highTotalCost));
    }

}
