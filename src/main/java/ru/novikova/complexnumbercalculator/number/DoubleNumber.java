package ru.novikova.complexnumbercalculator.number;

import java.util.Objects;

public class DoubleNumber extends DoubleNumberAbstract implements BasicArithmeticOperations<DoubleNumber> {

    public DoubleNumber(double value, Sign sign) {
        if (value < 0.0) throw new IllegalArgumentException("Значение value должно быть положительным числом");
        this.value = value;
        this.sign = sign;
    }

    public DoubleNumber(double value) {
        this(value, Sign.PLUS);
    }

    @Override
    public DoubleNumber add(DoubleNumber number) {
        if (this.sign.equals(number.sign)) {
            return new DoubleNumber(this.value + number.value, this.sign);
        } else {
            if (this.sign.equals(Sign.MINUS)) {
                return number.sub(new DoubleNumber(this.value, Sign.PLUS));
            } else return this.sub(new DoubleNumber(number.value, Sign.PLUS));
        }
    }

    @Override
    public DoubleNumber sub(DoubleNumber number) {
        if (this.sign.equals(Sign.MINUS) && number.getSign().equals(Sign.PLUS)) {
            return new DoubleNumber(this.value + number.value, Sign.MINUS);
        } else if (number.getSign().equals(Sign.MINUS)) {
            return this.add(new DoubleNumber(number.getIntValue(), Sign.PLUS));
        } else {
            if (this.value >= number.value) {
                return new DoubleNumber(this.value - number.value, Sign.PLUS);
            } else return new DoubleNumber(number.value - this.value, Sign.MINUS);
        }
    }

    @Override
    public DoubleNumber multiply(DoubleNumber number) {
        if (this.sign.equals(number.sign)) {
            return new DoubleNumber(this.value * number.value, Sign.PLUS);
        } else return new DoubleNumber(this.value * number.value, Sign.MINUS);
    }

    @Override
    public DoubleNumber divide(DoubleNumber number) {
        if (this.sign.equals(number.sign)) {
            return new DoubleNumber(this.getDoubleValue() / number.getDoubleValue(), Sign.PLUS);
        } else return new DoubleNumber(this.getDoubleValue() / number.getDoubleValue(), Sign.MINUS);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoubleNumber that)) return false;
        return Double.compare(value, that.value) == 0 && getSign() == that.getSign();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, getSign());
    }

    @Override
    public String toString() {
        return "DoubleNumber{" +
                "value=" + value +
                ", sign=" + sign +
                '}';
    }

    @Override
    public Sign getSign() {
        return sign;
    }
}
