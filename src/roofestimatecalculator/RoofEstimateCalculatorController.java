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
    private Slider numberStoriesSlider;
*/
    @FXML
    private TextField wasteRemovalCostInput;
    @FXML
    private TextField laborCostInput;
    @FXML
    private TextField materialCostInput;

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

        // Display or use the calculated costs
        materialCostInput.setText(String.valueOf(materialCost));
        laborCostInput.setText(String.valueOf(laborCost));
        wasteRemovalCostInput.setText(String.valueOf(wasteRemovalCost));
    }

}
