package ru.novikova.complexnumbercalculator.number;

import java.util.Objects;

public class ComplexNumber extends ComplexNumberAbstract implements BasicArithmeticOperations<ComplexNumber> {
    public ComplexNumber(DoubleNumber real, DoubleNumber imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(DoubleNumber real){
        this(real,new DoubleNumber(0.0));
    }

    @Override
    protected int getIntValue() {
        return real.getIntValue();
    }

    @Override
    protected double getDoubleValue() {
        return real.getDoubleValue();
    }

    @Override
    public ComplexNumber add(ComplexNumber number) {
        return new ComplexNumber(number.real.add(this.real), number.imaginary.add(this.imaginary));
    }

    @Override
    public ComplexNumber sub(ComplexNumber number) {
        return new ComplexNumber(this.real.sub(number.real), this.imaginary.sub(number.imaginary));
    }

    @Override
    public ComplexNumber multiply(ComplexNumber number) {
        return new ComplexNumber(
                ((this.real.multiply(number.real)).sub(this.imaginary.multiply(number.imaginary))),
                (this.real.multiply(number.imaginary).add(this.imaginary.multiply(number.real))));
    }


    @Override
    public ComplexNumber divide(ComplexNumber number) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComplexNumber that)) return false;
//        return Objects.equals(real, that.real) && Objects.equals(imaginary, that.imaginary);
        return Double.compare(real.value, that.real.value) == 0 && real.sign == that.real.sign&&
                Double.compare(imaginary.value, that.imaginary.value) == 0 && imaginary.sign == that.imaginary.sign;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real.value, real.sign, imaginary.value, imaginary.sign);
    }

    @Override
    public String toString() {
        return "ComplexNumber{" +
                "real=" + real +
                ", imaginary=" + imaginary +
                '}';
    }
}
