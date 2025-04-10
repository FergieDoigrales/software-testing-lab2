package functions;

public class CosecantFunction implements Function {
    private final SineFunction sine;

    public CosecantFunction(SineFunction sine) {
        this.sine = sine;
    }

    @Override
    public double calculate(double x, double epsilon) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            throw new IllegalArgumentException("x must be a finite number");
        }
        double sinValue = sine.calculate(x, epsilon/2);

        if (Math.abs(sinValue) < epsilon) {
            throw new ArithmeticException("Cosecant is undefined (cos(x) +-= zero)");
        }
        return 1.0 / sinValue;
    }
}