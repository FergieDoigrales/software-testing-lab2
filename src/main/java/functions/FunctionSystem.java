package functions;

import java.io.IOException;

public class FunctionSystem implements Function {
    private final SineFunction sin;
    private final NaturalLogarithm ln;
    private final CosineFunction cos;
    private final TangentFunction tan;
    private final CosecantFunction csc;
    private final Logarithm log2;
    private final Logarithm log5;
    private final Logarithm log10;

    public FunctionSystem(SineFunction sin, NaturalLogarithm ln, CosineFunction cos, TangentFunction tan,
                          CosecantFunction csc, Logarithm log2, Logarithm log5, Logarithm log10) {
        this.sin = sin;
        this.ln = ln;
        this.cos = cos;
        this.tan = tan;
        this.csc = csc;
        this.log2 = log2;
        this.log5 = log5;
        this.log10 = log10;
    }

    public FunctionSystem() {
        this.sin = new SineFunction();
        this.ln = new NaturalLogarithm();
        this.cos = new CosineFunction(sin);
        this.tan = new TangentFunction(sin, cos);
        this.csc = new CosecantFunction(sin);
        this.log2 = new Logarithm(ln, 2);
        this.log5 = new Logarithm(ln, 5);
        this.log10 = new Logarithm(ln, 10);
    }

    public double calculate(double x, double epsilon) {
        if (Double.isNaN(x) || Double.isInfinite(x) || Double.isNaN(epsilon) || Double.isInfinite(epsilon)) {
            throw new IllegalArgumentException("x must be a finite number");
        }
        if (x <= 0) {
            return ((((Math.pow(((csc.calculate(x, epsilon) -
                    cos.calculate(x, epsilon)) - tan.calculate(x, epsilon)), 2)) /
                    cos.calculate(x, epsilon)) * (Math.pow(tan.calculate(x, epsilon) - csc.calculate(x, epsilon), 2))));
        } else {
            return (Math.pow((((log10.calculate(x, epsilon) + log2.calculate(x, epsilon)) - log5.calculate(x, epsilon)) -
                    log2.calculate(x, epsilon)),2) * ((ln.calculate(x, epsilon) /
                    (log5.calculate(x, epsilon) - log10.calculate(x, epsilon))) + log2.calculate(x, epsilon)));
        }
    }
}
