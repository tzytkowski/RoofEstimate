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
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

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
    public Line line;

    @FXML
    public Line line2;

    @FXML
    public void calculateButtonClicked(ActionEvent event) {
        double length = Double.parseDouble(roofLengthInput.getText());
        double width = Double.parseDouble(roofWidthInput.getText());
        double area = length * width;
        roofAreaInput.setText(String.format("%.1f sq. ft", area));

        // Hypothetical values
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
                double sliderValue = newValue.doubleValue();
                if (slopeSlider.getValue() == 15.0) {
                    line.setEndY(line.getEndY() - 1.0);
                    line2.setStartY(line2.getStartY() - 1.0);
                } else if (sliderValue == 30.0) {
                    line.setEndY(line.getEndY() - 3.0);
                    line2.setStartY(line2.getStartY() - 3.0);
                } else if (sliderValue == 45.0) {
                    line.setEndY(line.getEndY() - 5.0);
                    line2.setStartY(line2.getStartY() - 5.0);
                } else {
                    System.out.println("Huh");
                }
            }
            // Calculate roofSlope based on the new Slider value
            double roofSlope = slopeSlider.getValue() * 0.10;

            // You can perform any actions you want here based on the new Slider value and roofSlope.
        }
    );
        double storiesSlope = (numberStoriesSlider.getValue() * slopeSlider.getValue());
    double highTotalCost = ((materialCost + laborCost + wasteRemovalCost + storiesSlope + 1000));

    highTotalCostInput.setText (formatCurrency
    (highTotalCost));
        double lowTotalCost = (materialCost + laborCost + wasteRemovalCost + storiesSlope - 1000);

    lowTotalCostInput.setText (formatCurrency

(lowTotalCost));
    }

    private String formatCurrency(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("$#,##0");
        return decimalFormat.format(value);
    }

    public void clearResults(ActionEvent e) {
        roofLengthInput.clear();
        roofWidthInput.clear();
        roofAreaInput.clear();
        materialCostInput.clear();
        laborCostInput.clear();
        wasteRemovalCostInput.clear();
        highTotalCostInput.clear();
        lowTotalCostInput.clear();
        line.setEndY(53.5);
        line2.setEndY(0);
        numberStoriesSlider.setValue(0);
        slopeSlider.setValue(0);
    }
}
