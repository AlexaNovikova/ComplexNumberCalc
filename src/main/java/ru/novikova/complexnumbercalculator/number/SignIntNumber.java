package ru.novikova.complexnumbercalculator.number;

import java.util.Objects;

public class SignIntNumber extends SignIntNumberAbstract implements BasicArithmeticOperations<SignIntNumber> {

    public SignIntNumber(int value, Sign sign) {
        this.value = value;
        this.sign = sign;
    }

    protected void setValue(int value) {
        this.value = value;
    }

    @Override
    public SignIntNumber add(SignIntNumber number) {
        if (this.sign.equals(number.sign)) {
            return new SignIntNumber(this.value + number.value, this.sign);
        } else {
            if (this.sign.equals(Sign.MINUS)) {
                return number.sub(new SignIntNumber(this.value, Sign.PLUS));
            } else return this.sub(new SignIntNumber(number.value, Sign.PLUS));
        }
    }

    @Override
    public SignIntNumber sub(SignIntNumber number) {
        if (this.sign.equals(Sign.MINUS) && number.getSign().equals(Sign.PLUS)) {
            return new SignIntNumber(this.value + number.value, Sign.MINUS);
        } else if (number.getSign().equals(Sign.MINUS)) {
            return this.add(new SignIntNumber(number.getIntValue(), Sign.PLUS));
        } else {
            if (this.value >= number.value) {
                return new SignIntNumber(this.value - number.value, Sign.PLUS);
            } else return new SignIntNumber(number.value - this.value, Sign.MINUS);
        }
    }

    @Override
    public SignIntNumber multiply(SignIntNumber number) {
        if (this.sign.equals(number.sign)) {
            return new SignIntNumber(this.value * number.value, Sign.PLUS);
        } else return new SignIntNumber(this.value * number.value, Sign.MINUS);
    }

    @Override
    public DoubleNumber divide(SignIntNumber number) {
        if(this.sign.equals(number.sign)) {
            return new DoubleNumber(this.getDoubleValue() / number.getDoubleValue(), Sign.PLUS);
        }
        else return new DoubleNumber(this.getDoubleValue() / number.getDoubleValue(), Sign.MINUS);
    }

    @Override
    public Sign getSign() {
        return this.sign;
    }

    @Override
    public String toString() {
        return "SignIntNumber{" +
                "value=" + value +
                ", sign=" + sign +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SignIntNumber that)) return false;
        return value == that.value && getSign() == that.getSign();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, getSign());
    }
}
