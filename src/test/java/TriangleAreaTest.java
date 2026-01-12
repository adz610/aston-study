import org.example.TriangleArea;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaTest {
    @DisplayName("Вычисление площади треугольника с положительными основанием и высотой")
    @Test
    void calculateWithValidInputs() {
        assertEquals(10, TriangleArea.calculate(4, 5));
    }

    @DisplayName("Вычисление площади треугольника с нулевым основанием (исключение)")
    @Test
    void calculateWithZeroBase() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculate(0, 5);
        });
    }

    @DisplayName("Вычисление площади треугольника с нулевой высотой (исключение)")
    @Test
    void calculateWithZeroHeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculate(4, 0);
        });
    }

    @DisplayName("Вычисление площади треугольника с отрицательными основанием и высотой (исключение)")
    @Test
    void calculateWithNegativeInputs() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculate(-4, -5);
        });
    }
}
