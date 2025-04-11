package functions;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;

public class CosineFunction implements Function {
    private final SineFunction sine;
    private static final MathContext MATH_CONTEXT = new MathContext(128);
    private static final BigDecimal HALF_PI = new BigDecimal("1.57079632679489661923");

    public CosineFunction(SineFunction sine) {
        this.sine = sine;
    }

    @Override
    public double calculate(double x, double epsilon) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            throw new IllegalArgumentException();
        }
        // cos^2(a) + sin^2(a) = 1
        // cos(x) = sin(x + pi/2)
        BigDecimal xBD = new BigDecimal(x, MATH_CONTEXT);
        BigDecimal shiftedX = xBD.add(HALF_PI, MATH_CONTEXT);
        return sine.calculate(shiftedX, epsilon); //погрешности плохо
    }

}
