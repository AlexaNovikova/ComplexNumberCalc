import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.novikova.complexnumbercalculator.number.NaturalNumber;
import ru.novikova.complexnumbercalculator.number.Sign;
import ru.novikova.complexnumbercalculator.number.SignIntNumber;


public class NaturalNumberTest {
    private final NaturalNumber number1 = new NaturalNumber(1);
    private final NaturalNumber number12 = new NaturalNumber(12);
    private final NaturalNumber number34 = new NaturalNumber(34);
    private final NaturalNumber number5 = new NaturalNumber(5);

    @Test
    public void testAdd(){
        Assertions.assertEquals(number1.add(number12),
                new NaturalNumber(13));
        Assertions.assertEquals(number12.add(number12),
                new NaturalNumber(24));
        Assertions.assertEquals(number1.add(number34),
                new NaturalNumber(35));
        Assertions.assertEquals(number5.add(number34),
                new NaturalNumber(39));
    }

    @Test
    public void testSub(){
        Assertions.assertEquals(number1.sub(number12),
                new SignIntNumber(11, Sign.MINUS));
        Assertions.assertEquals(number12.sub(number12),
                new SignIntNumber(0, Sign.PLUS));
        Assertions.assertEquals(number1.sub(number34),
                new SignIntNumber(33, Sign.MINUS));
        Assertions.assertEquals(number34.sub(number5),
                new SignIntNumber(29, Sign.PLUS));
    }

    @Test
    public void testMultiply(){
        Assertions.assertEquals(number1.multiply(number12),
                new NaturalNumber(12));
        Assertions.assertEquals(number12.multiply(number12),
                new NaturalNumber(144));
        Assertions.assertEquals(number5.multiply(number12),
                new NaturalNumber(60));
    }

}
