package functions;

public class FunctionSystem {
    private final SineFunction sin = new SineFunction();
    private final NaturalLogarithm ln = new NaturalLogarithm();
    private final CosineFunction cos = new CosineFunction(sin);
    private final TangentFunction tan = new TangentFunction(sin, cos);
    private final SecantFunction sec = new SecantFunction(cos);
    private final Logarithm log3 = new Logarithm(ln, 3);
    private final Logarithm log5 = new Logarithm(ln, 5);
    private final Logarithm log10 = new Logarithm(ln, 10);

    public double solve(double x, double epsilon) {
        if (x <= 0) {
            return (sec.calculate(x, epsilon) * tan.calculate(x, epsilon)) * cos.calculate(x, epsilon);
        } else {
            return (((((log10.calculate(x, epsilon) + ln.calculate(x, epsilon)) * log5.calculate(x, epsilon)) +
                    (Math.pow(log3.calculate(x, epsilon), 2))) + ((ln.calculate(x, epsilon) -
                    (Math.pow(log5.calculate(x, epsilon), 3)) +
                    (log5.calculate(x, epsilon) * log5.calculate(x, epsilon)))) * log10.calculate(x, epsilon)));
        }
    }
}
