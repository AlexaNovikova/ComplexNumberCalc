import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.novikova.complexnumbercalculator.number.Sign;
import ru.novikova.complexnumbercalculator.number.SignIntNumber;


public class SignIntNumberTest {
    private final SignIntNumber plus12 = new SignIntNumber(12, Sign.PLUS);
    public final SignIntNumber minus3 = new SignIntNumber(3, Sign.MINUS);
    public final SignIntNumber plus5 = new SignIntNumber(5,Sign.PLUS);
    public final SignIntNumber minus10 = new SignIntNumber(10, Sign.MINUS);
    @Test
    public void testAdd(){
        Assertions.assertEquals(plus5.add(plus12), new SignIntNumber(17, Sign.PLUS));
        Assertions.assertEquals(minus3.add(minus10), new SignIntNumber(13, Sign.MINUS));
        Assertions.assertEquals(minus10.add(plus5), new SignIntNumber(5, Sign.MINUS));
        Assertions.assertEquals(plus12.add(minus10), new SignIntNumber(2, Sign.PLUS));
        Assertions.assertEquals(plus5.add(minus10), new SignIntNumber(5, Sign.MINUS));
    }

    @Test
    public void testSub(){
        Assertions.assertEquals(plus5.sub(plus12), new SignIntNumber(7, Sign.MINUS));
        Assertions.assertEquals(minus3.sub(minus10), new SignIntNumber(7, Sign.PLUS));
        Assertions.assertEquals(minus10.sub(plus5), new SignIntNumber(15, Sign.MINUS));
        Assertions.assertEquals(plus12.sub(minus10), new SignIntNumber(22, Sign.PLUS));
        Assertions.assertEquals(plus12.sub(plus5), new SignIntNumber(7, Sign.PLUS));
    }

    @Test
    public void testMultiply(){
        Assertions.assertEquals(plus5.multiply(plus12), new SignIntNumber(60, Sign.PLUS));
        Assertions.assertEquals(minus3.multiply(minus10), new SignIntNumber(30, Sign.PLUS));
        Assertions.assertEquals(minus10.multiply(plus5), new SignIntNumber(50, Sign.MINUS));
        Assertions.assertEquals(plus12.multiply(minus10), new SignIntNumber(120, Sign.MINUS));
        Assertions.assertEquals(plus5.multiply(plus5), new SignIntNumber(25, Sign.PLUS));
    }
}
