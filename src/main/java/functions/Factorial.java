package functions;

import java.math.BigDecimal;

public class Factorial {
    public static BigDecimal factorial(int n) {
        if (n <= 1) return BigDecimal.ONE;
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }
}
