import functions.NaturalLogarithm;
import functions.SineFunction;

public class Main {
    public static void main(String[] args) {
        SineFunction sine = new SineFunction();
        System.out.println(sine.calculate(Math.PI/2, 0.00000000000001));
        NaturalLogarithm nL = new NaturalLogarithm();
        System.out.println(nL.calculate(3, 0.000000000001));
    }
}
