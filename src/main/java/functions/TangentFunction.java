package functions;

import java.math.BigDecimal;
import java.math.MathContext;

public class TangentFunction implements Function{
    private final SineFunction sine;
    private final CosineFunction cosine;
    private static final MathContext MATH_CONTEXT = new MathContext(128);
    private static final BigDecimal HALF_PI = new BigDecimal("1.57079632679489661923");
    private static final BigDecimal PI = new BigDecimal("3.14159265358979323846");

    public TangentFunction(SineFunction sine, CosineFunction cosine) {
        this.sine = sine;
        this.cosine = cosine;
    }

    @Override
    public double calculate(double x, double epsilon) {
        BigDecimal xBD = new BigDecimal(Double.toString(x), MATH_CONTEXT);
        if (xBD.abs().compareTo(HALF_PI.subtract(new BigDecimal(epsilon))) > 0) {
            throw new ArithmeticException("Tangent about infinity at pi/2 + pi_k");
        }

        double sin = sine.calculate(xBD, epsilon/2);
        double cos = cosine.calculate(x, epsilon/2);

        // cos +-= 0
        if (Math.abs(cos) < epsilon) {
            throw new ArithmeticException("Undefined tangent (cosine equals zero)");
        }

        return sin / cos;
    }
}
