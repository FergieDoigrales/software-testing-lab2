import functions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public abstract class ModuleTest {
    protected static final double EPSILON = 1e-6;

    protected static SineFunction sinMock;
    protected static CosineFunction cosMock;
    protected static TangentFunction tanMock;
    protected static CosecantFunction cscMock;
    protected static NaturalLogarithm lnMock;
    protected static Logarithm logBase2Mock;
    protected static Logarithm logBase5Mock;
    protected static Logarithm logBase10Mock;;


    @BeforeAll
    static void setUpMocks() {
        sinMock = mock(SineFunction.class);
        cosMock = mock(CosineFunction.class);
        tanMock = mock(TangentFunction.class);
        cscMock = mock(CosecantFunction.class);
        lnMock = mock(NaturalLogarithm.class);

        logBase2Mock = new Logarithm(lnMock, 2);
        logBase5Mock = new Logarithm(lnMock, 5);
        logBase10Mock = new Logarithm(lnMock, 10);

        when(sinMock.calculate(0,EPSILON)).thenReturn(0.0);
        when(cosMock.calculate(0, EPSILON)).thenReturn(1.0);
        when(tanMock.calculate(0, EPSILON)).thenReturn(0.0);
        when(cscMock.calculate(0, EPSILON)).thenThrow(ArithmeticException.class);

        when(lnMock.calculate(1, EPSILON)).thenReturn(0.0);
        when(logBase10Mock.calculate(1, EPSILON)).thenReturn(0.0);
        when(logBase5Mock.calculate(1, EPSILON)).thenReturn(0.0);
        when(logBase2Mock.calculate(1, EPSILON)).thenReturn(0.0);

        when(cosMock.calculate(-1.0, EPSILON)).thenReturn(0.540302);
        when(tanMock.calculate(-1.0, EPSILON)).thenReturn(-1.557408);
        when(cscMock.calculate(-1.0, EPSILON)).thenReturn(-1.188395);
    }
}
