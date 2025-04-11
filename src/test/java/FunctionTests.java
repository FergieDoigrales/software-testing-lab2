import functions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class FunctionTests extends ModuleTest {
    private static final double ACCURACY = 1e-3;

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(0.02, -0.159237),
                Arguments.of(0.02458, 0.0000315862),
                Arguments.of(0.05, 0.321657),
                Arguments.of(0.08454, 0.38055),
                Arguments.of(0.13, 0.34993),
                Arguments.of(0.8, 0.00875),
                Arguments.of(1, Double.NaN),
                Arguments.of(1.1, 0.00174),
                Arguments.of(2, 0.10677),

                Arguments.of(-0.973622, 0.01100172848872),
                Arguments.of(-1.032997, 0.00000000000333123),
                Arguments.of(-0.904557, 0.000000000000090383),
                Arguments.of(-1.0965, 0.20020671375987956),
                Arguments.of(-0.802, 0.20379720173887556),
                Arguments.of(-2.50374, -19.07324513954311),
                Arguments.of(-2.459, -19.50789340085),
                Arguments.of(-2.547, -19.503721783628897),
                Arguments.of(-3.82473, -74.68146225448464)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void funcTestWithMocks(double x, double expected) {
        FunctionSystem function = new FunctionSystem(sinMock, lnMock, cosMock, tanMock,
                cscMock, logBase2Mock, logBase5Mock, logBase10Mock);
        Assertions.assertEquals(expected, function.calculate(x, EPSILON), ACCURACY);
        System.out.println(function.calculate(x, EPSILON));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void funcTestWithTan(double x, double expected) {
        FunctionSystem function = new FunctionSystem(sinMock, lnMock, cosMock, tangentWithSinAndCosMock,
                cscMock, logBase2Mock, logBase5Mock, logBase10Mock);
        Assertions.assertEquals(expected, function.calculate(x, EPSILON), ACCURACY);
        System.out.println(function.calculate(x, EPSILON));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void funcTestLogarithm(double x, double expected) {
        FunctionSystem function = new FunctionSystem(sinMock, lnMock, cosMock, tanMock,
                cscMock, logBase2WithLnMock, logBase5WithLnMock, logBase10WithLnMock);
        Assertions.assertEquals(expected, function.calculate(x, EPSILON), ACCURACY);
        System.out.println(function.calculate(x, EPSILON));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void funcTestWithCsc(double x, double expected) {
        FunctionSystem function = new FunctionSystem(sinMock, lnMock, cosMock, tanMock,
                cosecantWithSinMock, logBase2Mock, logBase5Mock, logBase10Mock);
        Assertions.assertEquals(expected, function.calculate(x, EPSILON), ACCURACY);
        System.out.println(function.calculate(x, EPSILON));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void funcTestWithCos(double x, double expected) {
        FunctionSystem function = new FunctionSystem(sinMock, lnMock, cosine, tangentWithSinMock,
                cscMock, logBase2Mock, logBase5Mock, logBase10Mock);
        Assertions.assertEquals(expected, function.calculate(x, EPSILON), ACCURACY);
        System.out.println(function.calculate(x, EPSILON));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void funcTestWithLn(double x, double expected) {
        FunctionSystem function = new FunctionSystem(sinMock, nL, cosMock, tanMock,
                cscMock, logBase2, logBase5, logBase10);
        Assertions.assertEquals(expected, function.calculate(x, EPSILON), ACCURACY);
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void funcTestWithSin(double x, double expected) {
        FunctionSystem function = new FunctionSystem(sine, lnMock, cosMock, tangentWithCosMock,
                cosecant, logBase2Mock, logBase5Mock, logBase10Mock);
        Assertions.assertEquals(expected, function.calculate(x, EPSILON), ACCURACY);
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void funcTestWithNoMocks(double x, double expected){
        FunctionSystem function = new FunctionSystem(sine, nL, cosine, tangent,
                cosecant, logBase2, logBase5, logBase10);
        System.out.println(function.calculate(x, EPSILON));
        Assertions.assertEquals(expected, function.calculate(x, EPSILON), ACCURACY);
    }

}
