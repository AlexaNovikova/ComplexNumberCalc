package ru.novikova.complexnumbercalculator.number;

public abstract class ComplexNumberAbstract extends Number{
    protected DoubleNumber real;
    protected DoubleNumber imaginary;

    public DoubleNumber getReal() {
        return real;
    }

    public DoubleNumber getImaginary() {
        return imaginary;
    }
}
