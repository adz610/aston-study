import org.example.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @DisplayName("Сложение")
    @ParameterizedTest(name = "a={0}, b={1}, результат={2}")
    @CsvSource({
        "5, 5, 10",
        "1, -1, 0",
        "0, 0, 0",
        "-5, -5, -10"
    })
    void addition(int a, int b, int result) {
        assertEquals(result, Calculator.add(a, b));
    }

    @DisplayName("Вычитание")
    @ParameterizedTest(name = "a={0}, b={1}, результат={2}")
    @CsvSource({
        "10, 5, 5",
        "1, -1, 2",
        "0, 0, 0",
        "-5, -5, 0"
    })
    void subtraction(int a, int b, int result) {
        assertEquals(result, Calculator.subtract(a, b));
    }

    @DisplayName("Умножение")
    @ParameterizedTest(name = "a={0}, b={1}, результат={2}")
    @CsvSource({
        "2, 2, 4",
        "1, -1, -1",
        "0, 0, 0",
        "-5, -5, 25"
    })
    void multiplication(int a, int b, int result) {
        assertEquals(result, Calculator.multiply(a, b));
    }

    @DisplayName("Деление")
    @ParameterizedTest(name = "a={0}, b={1}, результат={2}")
    @CsvSource({
        "4, 2, 2",
        "1, -1, -1",
        "0, 1, 0",
        "-5, -5, 1"
    })
    void division(int a, int b, int result) {
        assertEquals(result, Calculator.divide(a, b));
    }

    @DisplayName("Деление на ноль (исключение)")
    @Test
    void divisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.divide(1, 0);
        });
    }
}
