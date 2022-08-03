package xyz.bubblesort.calculator;

public enum Operation {
  DOT("."), SIGN("+/-"), DIV1("1/x"), POWER2("x^2"), ROOT2("x^1/2"), PERCENTAGE("%"),
  CE("CE"), C("C"), DELETE("<-"), DIV("/"), PLUS("+"), MINUS("-"), MULT("*"), EQUALS("=");

  private final String name;

  Operation(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}


