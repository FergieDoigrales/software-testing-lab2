import functions.Logarithm;
import functions.NaturalLogarithm;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FunctionTests extends ModuleTest {
    private static final double LN_2 = 0.693147;
    private static final double LN_8 = 2.079441;
    private static final double LN_10 = 2.302585;
    private static final double LN_100 = 4.605170;

    @ParameterizedTest
    @CsvSource({
            "10.0, 10.0, 1.0",
            "2.0, 8.0, 0.33333",
            "100.0, 10.0, 2.0"
    })
    void testCalculate(double x, double base, double expected) {
        NaturalLogarithm lnMock = mock(NaturalLogarithm.class);

        switch ((int)x) {
            case 2 -> when(lnMock.calculate(2.0, EPSILON)).thenReturn(LN_2);
            case 10 -> when(lnMock.calculate(10.0, EPSILON)).thenReturn(LN_10);
            case 100 -> when(lnMock.calculate(100.0, EPSILON)).thenReturn(LN_100);
        }

        switch ((int)base) {
            case 8 -> when(lnMock.calculate(8.0, EPSILON)).thenReturn(LN_8);
            case 10 -> when(lnMock.calculate(10.0, EPSILON)).thenReturn(LN_10);
        }

        Logarithm log = new Logarithm(lnMock, base);
        assertEquals(expected, log.calculate(x, EPSILON), 0.0001);
    }

}
