import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.novikova.complexnumbercalculator.number.ComplexNumber;
import ru.novikova.complexnumbercalculator.number.DoubleNumber;
import ru.novikova.complexnumbercalculator.number.Sign;

public class ComplexNumberTest {
    private final ComplexNumber realPlus3ImaginaryMinus2 = new ComplexNumber(
            new DoubleNumber(3, Sign.PLUS),
            new DoubleNumber(2, Sign.MINUS)
    );

    private final ComplexNumber realPlus6ImaginaryPlus5 = new ComplexNumber(
            new DoubleNumber(6, Sign.PLUS),
            new DoubleNumber(5, Sign.PLUS)
    );

    private final ComplexNumber realPlus13ImaginaryMinus5 = new ComplexNumber(
            new DoubleNumber(13, Sign.PLUS),
            new DoubleNumber(5, Sign.MINUS)
    );

    private final ComplexNumber realMinus6ImaginaryPlus3 = new ComplexNumber(
            new DoubleNumber(6, Sign.MINUS),
            new DoubleNumber(3, Sign.PLUS)
    );

    private final ComplexNumber realMinus6ImaginaryMinus7 = new ComplexNumber(
            new DoubleNumber(6, Sign.MINUS),
            new DoubleNumber(7, Sign.MINUS)
    );

    @Test
    public void testAdd(){
        Assertions.assertEquals(realPlus3ImaginaryMinus2.add(realPlus6ImaginaryPlus5),
                new ComplexNumber(new DoubleNumber(9, Sign.PLUS), new DoubleNumber(3, Sign.PLUS)));
        Assertions.assertEquals(realMinus6ImaginaryMinus7.add(realPlus6ImaginaryPlus5),
                new ComplexNumber(new DoubleNumber(0, Sign.PLUS), new DoubleNumber(2, Sign.MINUS)));
        Assertions.assertEquals(realPlus13ImaginaryMinus5.add(realMinus6ImaginaryMinus7),
                new ComplexNumber(new DoubleNumber(7, Sign.PLUS), new DoubleNumber(12, Sign.MINUS)));

    }

    @Test
    public void testSub(){
        Assertions.assertEquals(realPlus3ImaginaryMinus2.sub(realPlus6ImaginaryPlus5),
                new ComplexNumber(new DoubleNumber(3, Sign.MINUS), new DoubleNumber(7, Sign.MINUS)));
        Assertions.assertEquals(realMinus6ImaginaryMinus7.sub(realPlus6ImaginaryPlus5),
                new ComplexNumber(new DoubleNumber(12, Sign.MINUS), new DoubleNumber(12, Sign.MINUS)));
        Assertions.assertEquals(realPlus13ImaginaryMinus5.sub(realMinus6ImaginaryMinus7),
                new ComplexNumber(new DoubleNumber(19, Sign.PLUS), new DoubleNumber(2, Sign.PLUS)));

    }
//
    @Test
    public void testMultiply(){
        Assertions.assertEquals(realPlus3ImaginaryMinus2.multiply(realPlus6ImaginaryPlus5),
                new ComplexNumber(new DoubleNumber(28, Sign.PLUS), new DoubleNumber(3, Sign.PLUS)));
        Assertions.assertEquals(realMinus6ImaginaryMinus7.multiply(realPlus6ImaginaryPlus5),
                new ComplexNumber(new DoubleNumber(1, Sign.MINUS), new DoubleNumber(72, Sign.MINUS)));
        Assertions.assertEquals(realPlus13ImaginaryMinus5.multiply(realMinus6ImaginaryMinus7),
                new ComplexNumber(new DoubleNumber(113, Sign.MINUS), new DoubleNumber(61, Sign.MINUS)));
    }
}
