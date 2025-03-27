package functions;

public class SecantFunction implements Function {
    private final CosineFunction cosine;

    public SecantFunction(CosineFunction cosine) {
        this.cosine = cosine;
    }

    @Override
    public double calculate(double x, double epsilon) {
        double cosValue = cosine.calculate(x, epsilon/2);

        if (Math.abs(cosValue) < epsilon) {
            throw new ArithmeticException("Secant is undefined (cos(x) +-= zero)");
        }
        return 1.0 / cosValue;
    }
}