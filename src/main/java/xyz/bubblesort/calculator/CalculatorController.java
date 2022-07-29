package xyz.bubblesort.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CalculatorController {

  @FXML
  private Text output;

  private String operator = "";
  private double number1 = 0;
  private boolean start = true;

  private final Set<String> singleOperators = new HashSet<>(Arrays.asList(".", "+/-", "1/x", "x^2", "x^1/2", "%", "CE", "C", "<-"));

  private boolean decimalSeparator = false;
  private final CalculatorModel model = new CalculatorModel();

  @FXML
  private void processNumpad(ActionEvent event) {
    if (start) {
      output.setText("");
      start = false;
    }
    String value = ((Button)event.getSource()).getText();
    output.setText(output.getText() + value);
  }

  @FXML
  private void processOperator(ActionEvent event) {
    String value = ((Button)event.getSource()).getText();
    if (!"=".equals(value)) {
      if (!output.getText().isEmpty()) {
        number1 = Double.parseDouble(output.getText());
      } else {
        number1 = 0;
      }
      if (!operator.isEmpty()) return;
      operator = value;
      if (singleOperators.contains(operator)) {
        if (!operator.equals(".") || !decimalSeparator) {
          output.setText(model.calculate(output.getText(), operator));
        }
        if (operator.equals(".") && !decimalSeparator) {
          decimalSeparator = true;
        }
        operator = "";
      } else {
        output.setText("");
      }
    } else {
      if (operator.isEmpty()) return;
      output.setText(String.valueOf(model.calculate(number1, Double.parseDouble(output.getText()),
            operator)));
      operator = "";
      start = true;
    }
  }
}