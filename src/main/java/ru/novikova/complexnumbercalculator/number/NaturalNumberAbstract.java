package ru.novikova.complexnumbercalculator.number;

public abstract class NaturalNumberAbstract extends Number {
    protected int value;

    @Override
    public int getIntValue() {
        return value;
    }

    @Override
    public double getDoubleValue() {
        return (double) value;
    }
}
