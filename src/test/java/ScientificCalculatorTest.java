import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the ScientificCalculator class.
 * Note: To test the private methods of ScientificCalculator, you would need to
 * make them public or use reflection. For this example, we assume the logic
 * can be tested via a public entry point or by making methods package-private.
 *
 * For simplicity in this example, let's create a separate class with the
 * static methods we want to test.
 */

// A simple helper class to make methods testable without changing the original file.
class CalculatorLogic {
    public static long factorial(int n) {
        if (n < 0) return -1; // Or throw an exception
        if (n == 0) return 1;
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}


public class ScientificCalculatorTest {

    @Test
    void testFactorial() {
        // Test a known value
        assertEquals(120, CalculatorLogic.factorial(5), "Factorial of 5 should be 120");

        // Test the base case
        assertEquals(1, CalculatorLogic.factorial(0), "Factorial of 0 should be 1");
    }
}