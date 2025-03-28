import functions.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SineFunction sine = new SineFunction();
        System.out.println(sine.calculate(Math.PI/2, 0.00000000000001));
        NaturalLogarithm nL = new NaturalLogarithm();
        System.out.println(nL.calculate(3, 0.000000000001));
        Logarithm logarithm = new Logarithm(nL, 2);
        System.out.println(logarithm.calculate(8, 0.0000000000000001));
        CosineFunction cosine = new CosineFunction(sine);
        System.out.println(cosine.calculate(Math.PI/2, 1e-15));
        TangentFunction tangent = new TangentFunction(sine, cosine);
        System.out.println(tangent.calculate(Math.PI/4, 1e-15));
        CsvExporter.exportToCsv(
                new NaturalLogarithm(),
                0.1, 5.0, 0.5, 1e-6,
                "ln_results.csv"
        );
    }
}
