package functions;

import java.math.BigDecimal;
import java.math.MathContext;

public class NaturalLogarithm implements Function {
    private static final MathContext MATH_CONTEXT = new MathContext(128);

    @Override
    public double calculate(double z, double epsilon) {
        if (z <= 0) {
            throw new IllegalArgumentException("x must be positive");
        }

        //(z - 1)/(z + 1)
        BigDecimal zBD = new BigDecimal(z, MATH_CONTEXT);
        BigDecimal x = zBD.subtract(BigDecimal.ONE)
                .divide(zBD.add(BigDecimal.ONE), MATH_CONTEXT);

        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal term;
        int n = 1;
        BigDecimal epsilonBD = new BigDecimal(epsilon, MATH_CONTEXT);
        BigDecimal TWO = new BigDecimal(2);

        //2*(x + x³/3 + x⁵/5 + x⁷/7 + ...)
        do {
            //x^(2n-1)/(2n-1)
            term = x.pow(2 * n - 1, MATH_CONTEXT)
                    .divide(new BigDecimal(2 * n - 1), MATH_CONTEXT);

            sum = sum.add(term, MATH_CONTEXT);
            n++;
        } while (term.abs().compareTo(epsilonBD) > 0);

        return sum.multiply(TWO).doubleValue();
    }

}
