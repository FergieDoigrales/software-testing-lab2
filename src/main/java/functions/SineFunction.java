package functions;

import java.math.BigDecimal;
import java.math.MathContext;

public class SineFunction implements Function {
    private final static MathContext MATH_CONTEXT = MathContext.DECIMAL128;
    private static final BigDecimal PI = new BigDecimal("3.14159265358979323846");
    private static final BigDecimal HALF_PI = new BigDecimal("1.57079632679489661923");
    private static final BigDecimal TWO_PI = new BigDecimal("6.28318530717958647692");

    @Override
    public double calculate(double x, double epsilon) {
        return calculate(new BigDecimal(x), epsilon);
    }

    public double calculate(BigDecimal xBD, double epsilon){
        BigDecimal epsilonBD = new BigDecimal(epsilon);
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal term;
        int n = 0;

        if (xBD.abs().compareTo(HALF_PI) > 0) {
            xBD = xBD.remainder(TWO_PI, MATH_CONTEXT);
            if (xBD.compareTo(PI) > 0) {
                xBD = xBD.subtract(TWO_PI, MATH_CONTEXT);
            }
        }

        do { //(-1)^n * x^(2n+1)/(2n+1)!
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

