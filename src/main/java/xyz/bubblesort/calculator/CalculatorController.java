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

  private Operation operation;
  private double number1 = 0;
  private boolean start = true;

  private final Set<String> singleOperators = new HashSet<>(Arrays.asList(".", "+/-", "1/x", "x^2", "x^1/2", "%", "CE", "C", "<-"));

  private final CalculatorModel model = new CalculatorModel();

  @FXML
  private void processNumpad(ActionEvent event) {
    if (start) {
      output.setText("");
      start = false;
    }
    String operationName = ((Button)event.getSource()).getText();
    output.setText(output.getText() + operationName);
  }

  @FXML
  private void processOperator(ActionEvent event) {
    String operationName = ((Button)event.getSource()).getText();
    if (!"=".equals(operationName)) {
      if (!output.getText().isEmpty()) {
        number1 = Double.parseDouble(output.getText());
      } else {
        number1 = 0;
      }
      if (!operationName.equals(".") && operation != null ) return;
      for (Operation op : Operation.values()) {
        if (op.getName().equals(operationName)) {
          operation = op;
          break;
        }
      }
      if (operation == null) {
        throw new IllegalArgumentException("Operation does not exist");
      }
      if (operationName.equals(".")) {
        if (!output.getText().contains(".")) {
          output.setText(model.calculate(output.getText(), operation));
        }
      } else {
        if (singleOperators.contains(operation.getName())) {
          output.setText(model.calculate(output.getText(), operation));
          operation = null;
        }
      }
    } else {
      if (operation == null) return;
      output.setText(String.valueOf(model.calculate(number1, Double.parseDouble(output.getText()),
            operation)));
      operation = null;
      start = true;
    }
  }
}