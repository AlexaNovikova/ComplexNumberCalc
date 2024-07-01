package ru.novikova.complexnumbercalculator.number;

import java.util.Objects;

public class FractionNumber extends Number implements BasicArithmeticOperations<FractionNumber>, GetSign {

    private SignIntNumber numerator;
    private int denominator;

    public FractionNumber(int numerator, int denominator) {
        this(numerator, denominator, Sign.PLUS);
    }

    public FractionNumber(int numerator){
        this(numerator,1);
    }

    public FractionNumber(int numerator, int denominator, Sign sign){
        super();
        if(denominator == 0) throw new IllegalArgumentException("В знаменателе не может быть 0");
        this.numerator = new SignIntNumber(numerator, sign);
        this.denominator = denominator;
    }


    public int getDenominator() {
        return denominator;
    }

    @Override
    public Sign getSign() {
        return numerator.getSign();
    }

    public SignIntNumber getNumerator() {
        return numerator;
    }

    @Override
    public int getIntValue() {
        return numerator.getIntValue()/denominator;
    }

    @Override
    public double getDoubleValue() {
        return numerator.getDoubleValue() /denominator;
    }

    @Override
    public FractionNumber add(FractionNumber number) {
       if(this.denominator == number.getDenominator()){
           SignIntNumber resNumerator = this.numerator.add(number.getNumerator());
           return new FractionNumber(resNumerator.getIntValue()
                   ,denominator, resNumerator.getSign()).simplify();
       }
       else {
           return this.multiply(new NaturalNumber(number.getDenominator()))
                   .add(number.multiply(new NaturalNumber(this.getDenominator())));
       }
    }

    @Override
    public FractionNumber sub(FractionNumber number) {
        if(this.denominator == number.getDenominator()){
            SignIntNumber resNumerator = this.numerator.sub(number.getNumerator());
            return new FractionNumber(resNumerator.getIntValue()
                    ,denominator, resNumerator.getSign()).simplify();
        }
        else {
            return this.multiply(new NaturalNumber(number.getDenominator()))
                    .sub(number.multiply(new NaturalNumber(this.getDenominator())));
        }
    }

    @Override
    public FractionNumber multiply(FractionNumber number) {
        SignIntNumber resNumerator = this.numerator.multiply(number.getNumerator());
        int rezDenominator = this.denominator*number.denominator;
        return new FractionNumber(resNumerator.getIntValue(), rezDenominator, resNumerator.getSign()).simplify();
    }

    public FractionNumber multiply(NaturalNumber number){
        return new FractionNumber(numerator.getIntValue()*number.getIntValue(),
                denominator * number.getIntValue(), this.getSign());
    }

    @Override
    public FractionNumber divide(FractionNumber number) {
       return this.multiply(new FractionNumber(number.denominator,
               number.numerator.getIntValue(), number.getSign()));
    }

    public FractionNumber simplify(){
        int NOD = gcdByEuclidsAlgorithm(numerator.getIntValue(), denominator);
        this.numerator.setValue(numerator.getIntValue()/NOD);
        this.denominator = denominator/NOD;
        if(numerator.getIntValue()==0){
            this.denominator = 1;
        }
        return this;
    }

    int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }

    @Override
    public String toString() {
        return "FractionNumber{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FractionNumber that)) return false;
        return getDenominator() == that.getDenominator() && Objects.equals(getNumerator(), that.getNumerator());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumerator(), getDenominator());
    }

}
