import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.novikova.complexnumbercalculator.number.FractionNumber;
import ru.novikova.complexnumbercalculator.number.Sign;

public class FractionNumberTest {
    private final FractionNumber plus12d3 = new FractionNumber(12,3);
    public final FractionNumber minus3d4 = new FractionNumber(3,4, Sign.MINUS);
    public final FractionNumber plus1d3 = new FractionNumber(1,3);
    private final FractionNumber minus4d5 = new FractionNumber(4,5,Sign.MINUS);

    @Test
    public void testAdd(){
        Assertions.assertEquals(new FractionNumber(31,20, Sign.MINUS),
                minus3d4.add(minus4d5));
        Assertions.assertEquals(new FractionNumber(8,5, Sign.MINUS),
                minus4d5.add(minus4d5));
        Assertions.assertEquals(new FractionNumber(5,12, Sign.MINUS),
               plus1d3.add(minus3d4));
        Assertions.assertEquals(new FractionNumber(2,3, Sign.PLUS),
                plus1d3.add(plus1d3));
        Assertions.assertEquals(new FractionNumber(16,5, Sign.PLUS),
                plus12d3.add(minus4d5));
    }

    @Test
    public void testSub(){
        Assertions.assertEquals(new FractionNumber(1,20, Sign.PLUS),
                minus3d4.sub(minus4d5));
        Assertions.assertEquals(new FractionNumber(0,1, Sign.PLUS),
                minus4d5.sub(minus4d5));
        Assertions.assertEquals(new FractionNumber(13,12, Sign.PLUS),
                plus1d3.sub(minus3d4));
        Assertions.assertEquals(new FractionNumber(13,12, Sign.MINUS),
                minus3d4.sub(plus1d3));
        Assertions.assertEquals(new FractionNumber(24,5, Sign.PLUS),
                plus12d3.sub(minus4d5));
    }

    @Test
    public void testMultiply(){
        Assertions.assertEquals(new FractionNumber(3,5, Sign.PLUS),
                minus3d4.multiply(minus4d5));
        Assertions.assertEquals(new FractionNumber(16,25, Sign.PLUS),
                minus4d5.multiply(minus4d5));
        Assertions.assertEquals(new FractionNumber(1,4, Sign.MINUS),
                plus1d3.multiply(minus3d4));
        Assertions.assertEquals(new FractionNumber(1,4, Sign.MINUS),
                minus3d4.multiply(plus1d3));
        Assertions.assertEquals(new FractionNumber(16,5, Sign.MINUS),
                plus12d3.multiply(minus4d5));
    }

    @Test
    public void testDivide(){
        Assertions.assertEquals(new FractionNumber(15,16, Sign.PLUS),
                minus3d4.divide(minus4d5));
        Assertions.assertEquals(new FractionNumber(1,1, Sign.PLUS),
                minus4d5.divide(minus4d5));
        Assertions.assertEquals(new FractionNumber(4,9, Sign.MINUS),
                plus1d3.divide(minus3d4));
        Assertions.assertEquals(new FractionNumber(9,4, Sign.MINUS),
                minus3d4.divide(plus1d3));
        Assertions.assertEquals(new FractionNumber(5,1, Sign.MINUS),
                plus12d3.divide(minus4d5));
    }
}
