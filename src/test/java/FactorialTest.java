import org.example.Factorial;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    @DisplayName("Факториал нуля")
    @Test
    void factorialOfZero() {
        assertEquals(1, Factorial.calculate(0));
    }

    @DisplayName("Факториал единицы")
    @Test
    void factorialOfOne() {
        assertEquals(1, Factorial.calculate(1));
    }

    @DisplayName("Факториал положительного числа больше 1")
    @Test
    void factorialOfPositiveNumber() {
        assertEquals(120, Factorial.calculate(5));
    }

    @DisplayName("Факториал отрицательного числа (исключение)")
    @Test
    void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculate(-5);
        });
    }
}
