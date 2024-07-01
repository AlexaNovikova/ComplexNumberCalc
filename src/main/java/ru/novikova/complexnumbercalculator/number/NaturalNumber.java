package ru.novikova.complexnumbercalculator.number;

import java.util.Objects;

public class NaturalNumber extends NaturalNumberAbstract implements BasicArithmeticOperations<NaturalNumber> {
    protected int value;

    public NaturalNumber(int value) {
        this.value = value;
    }

    @Override
    public int getIntValue() {
        return this.value;
    }

    @Override
    public double getDoubleValue() {
        return (double) this.value;
    }

    @Override
    public NaturalNumber add(NaturalNumber number) {
        return new NaturalNumber(this.value + number.getIntValue());
    }

    @Override
    public SignIntNumber sub(NaturalNumber number) {
        return new SignIntNumber(this.value, Sign.PLUS).sub(new SignIntNumber(number.value, Sign.PLUS));
    }

    @Override
    public NaturalNumber multiply(NaturalNumber number) {
        return new NaturalNumber(this.value * number.getIntValue());
    }

    @Override
    public DoubleNumber divide(NaturalNumber number) {
        return new DoubleNumber(this.getDoubleValue() / number.getDoubleValue(), Sign.PLUS);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NaturalNumber number)) return false;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "NaturalNumber{" +
                "value=" + value +
                '}';
    }
}
