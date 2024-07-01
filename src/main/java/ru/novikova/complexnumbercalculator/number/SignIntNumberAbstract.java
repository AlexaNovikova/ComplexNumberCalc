package ru.novikova.complexnumbercalculator.number;

public abstract class SignIntNumberAbstract extends NaturalNumberAbstract implements GetSign {
    protected Sign sign;
    public Sign getSign() {
        return sign;
    }
}
