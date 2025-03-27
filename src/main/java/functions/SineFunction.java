package functions;

import java.math.BigDecimal;
import java.math.MathContext;

public class SineFunction implements Function {
    private final static MathContext MATH_CONTEXT = MathContext.DECIMAL128;
    private static final BigDecimal PI = new BigDecimal("3.14159265358979323846");
    private static final BigDecimal HALF_PI = PI.divide(BigDecimal.valueOf(2), MATH_CONTEXT);

    @Override
    public double calculate(double x, double epsilon) {
        BigDecimal xBD = new BigDecimal(x);
        BigDecimal epsilonBD = new BigDecimal(epsilon);
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal term;
        int n = 0;

        if (xBD.abs().compareTo(HALF_PI) > 0) {
            throw new IllegalArgumentException("x should be in range [-pi/2, pi/2]");
        }

        do {
            BigDecimal numerator = xBD.pow(2 * n + 1);
            if (n % 2 != 0) {
                numerator = numerator.negate();
            }
            BigDecimal denominator = Factorial.factorial(2*n + 1);
            term = numerator.divide(denominator, MATH_CONTEXT);
            result = result.add(term);
            n++;
        } while (term.abs().compareTo(epsilonBD) > 0);
        return result.doubleValue();
    }
}
