package xyz.bubblesort.calculator;

public class CalculatorModel {
  public double calculate(double number1, double number2, Operation operation) {
    switch (operation.getName()) {
      case "+":
        return number1 + number2;
      case "-":
        return number1 - number2;
      case "*":
        return number1 * number2;
      case "/":
        if (number2 == 0) {
          return 0;
        } else {
          return number1 / number2;
        }
    }
    System.out.println("Unknown operation - " + operation);
    return 0;
  }

  public String calculate(String number, Operation operation) {
    if (number.isEmpty()) return number;
    switch (operation.getName()) {
      case "%":
        return String.valueOf(Double.parseDouble(number) / 100);
      case "C":
      case "CE":
        return "";
      case "<-":
        return number.substring(0,number.length() - 1);
      case ".":
        return number + ".";
      case "+/-":
          if (number.charAt(0) == '-') {
            return number.substring(1);
          } else {
            return "-" + number;
          }

      case "1/x":
        return String.valueOf(1 / Double.parseDouble(number));
      case "x^2":
        return String.valueOf(Math.pow(Double.parseDouble(number), 2));
      case "x^1/2":
        return String.valueOf(Math.sqrt(Double.parseDouble(number)));
    }
    System.out.println("Unknown operation - " + operation);
    return "";
  }

}
