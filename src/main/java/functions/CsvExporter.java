package functions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class CsvExporter {
    public static void exportToCsv(Function function,
                                   double from,
                                   double to,
                                   double step,
                                   double epsilon,
                                   String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("x,result\n");

            for (double x = from; x <= to; x += step) {
                try {
                    double result = function.calculate(x, epsilon);
                    String line = String.format(Locale.US, "%.6f,%.6f\n", x, result);
                    writer.write(line);
                } catch (ArithmeticException | IllegalArgumentException e) {
                    writer.write(String.format("%f,undefined\n", x));
                }
            }
        }
    }
}
