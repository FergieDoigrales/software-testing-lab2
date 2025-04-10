import functions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FunctionTests extends ModuleTest {
    private static final NaturalLogarithm nL = new NaturalLogarithm();
    private static final Logarithm logBase2 = new Logarithm(nL, 2);
    private static final Logarithm logBase5 = new Logarithm(nL, 5);
    private static final Logarithm logBase10 = new Logarithm(nL, 10);
    private static final SineFunction sine = new SineFunction();
    private static final CosineFunction cosine = new CosineFunction(sine);
    private static final TangentFunction tangent = new TangentFunction(sine, cosine);
    private static final CosecantFunction cosecant = new CosecantFunction(sine);


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, Double.NaN),
                Arguments.of(-1, 0.0073944869340584)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void funcTestWithMocks(double x, double expected){
        FunctionSystem function = new FunctionSystem(sinMock, lnMock, cosMock, tanMock,
                cscMock, logBase2Mock, logBase5Mock, logBase10Mock);
        Assertions.assertEquals(expected, function.solve(x, EPSILON), EPSILON);
        System.out.println(function.solve(x, EPSILON));
    }

    @Test
    public void zeroValueXTestWithMocks() {
        FunctionSystem function = new FunctionSystem(sinMock, lnMock, cosMock, tanMock,
                cscMock, logBase2Mock, logBase5Mock, logBase10Mock);
        assertThrows(ArithmeticException.class, () -> function.solve(0, EPSILON));
    }


    @ParameterizedTest
    @MethodSource("testData")
    public void funcTestWithSin(double x, double expected){
        FunctionSystem function = new FunctionSystem(sine, lnMock, cosMock, tanMock,
                cscMock, logBase2Mock, logBase5Mock, logBase10Mock);
        Assertions.assertEquals(expected, function.solve(x, EPSILON), EPSILON);
        System.out.println(function.solve(x, EPSILON));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void funcTestWithLn(double x, double expected){
        FunctionSystem function = new FunctionSystem(sinMock, nL, cosMock, tanMock,
                cscMock, logBase2Mock, logBase5Mock, logBase10Mock);
        Assertions.assertEquals(expected, function.solve(x, EPSILON), EPSILON);
        System.out.println(function.solve(x, EPSILON));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void funcTestWithCos(double x, double expected){
        FunctionSystem function = new FunctionSystem(sinMock, lnMock, cosine, tanMock,
                cscMock, logBase2Mock, logBase5Mock, logBase10Mock);
        Assertions.assertEquals(expected, function.solve(x, EPSILON), EPSILON);
        System.out.println(function.solve(x, EPSILON));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void funcTestWithTan(double x, double expected){
        FunctionSystem function = new FunctionSystem(sinMock, lnMock, cosMock, tangent,
                cscMock, logBase2Mock, logBase5Mock, logBase10Mock);
        Assertions.assertEquals(expected, function.solve(x, EPSILON), EPSILON);
        System.out.println(function.solve(x, EPSILON));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void funcTestWithCsc(double x, double expected){
        FunctionSystem function = new FunctionSystem(sinMock, lnMock, cosMock, tanMock,
                cosecant, logBase2Mock, logBase5Mock, logBase10Mock);
        Assertions.assertEquals(expected, function.solve(x, EPSILON), EPSILON);
        System.out.println(function.solve(x, EPSILON));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void funcTestLogarithm(double x, double expected){
        FunctionSystem function = new FunctionSystem(sinMock, lnMock, cosMock, tanMock,
                cscMock, logBase2, logBase5, logBase10);
        Assertions.assertEquals(expected, function.solve(x, EPSILON), EPSILON);
        System.out.println(function.solve(x, EPSILON));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void funcTestLog5(double x, double expected){
        FunctionSystem function = new FunctionSystem(sinMock, lnMock, cosMock, tanMock,
                cscMock, logBase2Mock, logBase5, logBase10Mock);
        Assertions.assertEquals(expected, function.solve(x, EPSILON), EPSILON);
        System.out.println(function.solve(x, EPSILON));
    }

}
