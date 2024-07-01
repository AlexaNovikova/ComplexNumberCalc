package ru.novikova.complexnumbercalculator.number;

public abstract class DoubleNumberAbstract extends Number implements GetSign{

    protected double value;
    protected Sign sign;


    @Override
    protected int getIntValue() {
        return (int) value;
    }

    @Override
    protected double getDoubleValue() {
        return value;
    }
}
