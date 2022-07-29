module xyz.bubblesort.calculator {
  requires javafx.controls;
  requires javafx.fxml;


  opens xyz.bubblesort.calculator to javafx.fxml;
  exports xyz.bubblesort.calculator;
}