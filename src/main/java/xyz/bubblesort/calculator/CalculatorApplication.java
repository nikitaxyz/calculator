package xyz.bubblesort.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorApplication extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("ui.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Calculator");
    stage.setScene(scene);
    stage.sizeToScene();
    stage.show();
    stage.setMinWidth(stage.getWidth());
    stage.setMinHeight(stage.getHeight());
  }

  public static void main(String[] args) {
    launch();
  }
}