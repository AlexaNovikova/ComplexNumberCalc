package ru.novikova.complexnumbercalculator.number;

public enum Sign {
 PLUS ("+"),
 MINUS("-");

 private String signSymbol;

 Sign(String signSymbol) {

  this.signSymbol = signSymbol;
 }

 public String getSignSymbol() {
  return signSymbol;
 }
}
