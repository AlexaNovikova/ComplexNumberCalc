import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.novikova.complexnumbercalculator.number.DoubleNumber;
import ru.novikova.complexnumbercalculator.number.Sign;


public class DoubleNumberTest {
    private final DoubleNumber plus12 = new DoubleNumber(12.0, Sign.PLUS);
    public final DoubleNumber minus3 = new DoubleNumber(3.0, Sign.MINUS);
    public final DoubleNumber plus5 = new DoubleNumber(5.0,Sign.PLUS);
    public final DoubleNumber minus10 = new DoubleNumber(10.0, Sign.MINUS);
    @Test
    public void testAdd(){
        Assertions.assertEquals(plus5.add(plus12), new DoubleNumber(17.0, Sign.PLUS));
        Assertions.assertEquals(minus3.add(minus10), new DoubleNumber(13.0, Sign.MINUS));
        Assertions.assertEquals(minus10.add(plus5), new DoubleNumber(5.0, Sign.MINUS));
        Assertions.assertEquals(plus12.add(minus10), new DoubleNumber(2.0, Sign.PLUS));
        Assertions.assertEquals(plus5.add(minus10), new DoubleNumber(5.0, Sign.MINUS));
    }

    @Test
    public void testSub(){
        Assertions.assertEquals(plus5.sub(plus12), new DoubleNumber(7.0, Sign.MINUS));
        Assertions.assertEquals(minus3.sub(minus10), new DoubleNumber(7.0, Sign.PLUS));
        Assertions.assertEquals(minus10.sub(plus5), new DoubleNumber(15.0, Sign.MINUS));
        Assertions.assertEquals(plus12.sub(minus10), new DoubleNumber(22.0, Sign.PLUS));
        Assertions.assertEquals(plus12.sub(plus5), new DoubleNumber(7.0, Sign.PLUS));
    }

    @Test
    public void testMultiply(){
        Assertions.assertEquals(plus5.multiply(plus12), new DoubleNumber(60.0, Sign.PLUS));
        Assertions.assertEquals(minus3.multiply(minus10), new DoubleNumber(30.0, Sign.PLUS));
        Assertions.assertEquals(minus10.multiply(plus5), new DoubleNumber(50.0, Sign.MINUS));
        Assertions.assertEquals(plus12.multiply(minus10), new DoubleNumber(120.0, Sign.MINUS));
        Assertions.assertEquals(plus5.multiply(plus5), new DoubleNumber(25.0, Sign.PLUS));
    }
}
