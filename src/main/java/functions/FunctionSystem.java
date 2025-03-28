package functions;

public class FunctionSystem {
    private final SineFunction sin;
    private final NaturalLogarithm ln;
    private final CosineFunction cos;
    private final TangentFunction tan;
    private final SecantFunction sec;
    private final Logarithm log3;
    private final Logarithm log5;
    private final Logarithm log10;

    public FunctionSystem(SineFunction sin, NaturalLogarithm ln, CosineFunction cos, TangentFunction tan,
                          SecantFunction sec, Logarithm log3, Logarithm log5, Logarithm log10) {
        this.sin = sin;
        this.ln = ln;
        this.cos = cos;
        this.tan = tan;
        this.sec = sec;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }

    public FunctionSystem() {
        this.sin = new SineFunction();
        this.ln = new NaturalLogarithm();
        this.cos = new CosineFunction(sin);
        this.tan = new TangentFunction(sin, cos);
        this.sec = new SecantFunction(cos);
        this.log3 = new Logarithm(ln, 3);
        this.log5 = new Logarithm(ln, 5);
        this.log10 = new Logarithm(ln, 10);
    }

    public double solve(double x, double epsilon) {
        if (Double.isNaN(x) || Double.isInfinite(x) || Double.isNaN(epsilon) || Double.isInfinite(epsilon)) {
            throw new IllegalArgumentException("x must be a finite number");
        }
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
