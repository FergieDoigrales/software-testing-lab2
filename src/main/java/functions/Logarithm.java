package functions;

import java.math.MathContext;

public class Logarithm implements Function {
    private final NaturalLogarithm ln;
    private final double base;
    private static final MathContext MC = new MathContext(128);

    public Logarithm(NaturalLogarithm ln, double base) {
        this.ln = ln;
        this.base = base;
    }

    @Override
    public double calculate(double x, double epsilon) {
        if (x <= 0) {
            throw new IllegalArgumentException("x must be positive");
        }
        if (base < 0 || base == 1) {
            throw new IllegalArgumentException("Base must be greater than 0 and not equal to 1");
        }

        //log_a(x) = ln(x)/ln(a)
        double lnX = ln.calculate(x, epsilon);
        double lnBase =ln.calculate(base, epsilon);

        return lnX / lnBase;
    }
}
