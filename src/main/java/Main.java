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
//        System.out.println(tangent.calculate(Math.PI/4, 1e-15));
        FunctionSystem functionSystem = new FunctionSystem();
//        Arguments.of(0.02458, 0),
//                Arguments.of(0.05, 0.32166),
//                Arguments.of(0.08454, 0.38055),
//                Arguments.of(0.13, 0.34993),
//                Arguments.of(0.05, 0.32166),
//                Arguments.of(0.8, 0.00875),
//                Arguments.of(1, Double.NaN),
//                Arguments.of(1.1, 0.00174),
//                Arguments.of(2, 0.10677)
//        System.out.println("KROTOVUHA " + functionSystem.calculate(0.02458, 1e-15) + "expected: 0");
//        System.out.println("KROTOVUHA " + functionSystem.calculate(0.05, 1e-15) + "expected: 0.32166");
//        System.out.println("KROTOVUHA " + functionSystem.calculate(0.13, 1e-15) + "expected: 0.34993");
        System.out.println("KROTOVUHA " + functionSystem.calculate(0.02, 1e-15));
        System.out.println("KROTOVUHA " + functionSystem.calculate(-0.973622, 1e-15));

        System.out.println("KROTOVUHA " + cosine.calculate(-0.973622, 1e-15/2));

        System.out.println("KROTOVUHA323232 " + -0.8269278129793861/0.5623080935938318);
//        CsvExporter.exportToCsv(
//                new FunctionSystem(),
//                -1.0, 5.0, 0.5, 1e-6,
//                "ln_results.csv"
//        );

    }
}
