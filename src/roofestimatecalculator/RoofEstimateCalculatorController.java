package roofestimatecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RoofEstimateCalculatorController {
    @FXML
    private Label roofLengthInput;
    @FXML
    private TextField roofWidthInput;

    private TextField roofAreaInput;
    @FXML
    private Button submitButton;


    @FXML
    private void calculateButtonClicked(ActionEvent event) {
        try {
            double length = Double.parseDouble(roofLengthInput.getText());
            double width = Double.parseDouble(roofWidthInput.getText());

            double area = length * width;

            roofAreaInput.setText(String.valueOf(area));
        } catch (NumberFormatException e) {
            roofAreaInput.setText("Invalid input");
        }
    }
}