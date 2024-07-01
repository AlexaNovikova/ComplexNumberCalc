package ru.novikova.complexnumbercalculator.number;

public interface BasicArithmeticOperations<T extends Number> {
    T add(T number);

    <N extends Number> N sub(T number);

    T multiply(T number);

    <N extends Number> N divide(T number);
}
