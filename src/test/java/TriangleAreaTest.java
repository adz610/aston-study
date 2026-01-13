import org.example.TriangleArea;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleAreaTest extends Assert{
    @Test(description = "Вычисление площади треугольника с положительными основанием и высотой")
    void calculateWithValidInputs() {
        assertEquals(TriangleArea.calculate(4, 5), 10, 0.0001);
    }

    @Test(description = "Вычисление площади треугольника с нулевым основанием (исключение)",
        expectedExceptions = IllegalArgumentException.class)
    void calculateWithZeroBase() {
        TriangleArea.calculate(0, 5);
    }

    @Test(description = "Вычисление площади треугольника с нулевой высотой (исключение)",
        expectedExceptions = IllegalArgumentException.class)
    void calculateWithZeroHeight() {
        TriangleArea.calculate(4, 0);
    }

    @Test(description = "Вычисление площади треугольника с отрицательными основанием и высотой (исключение)",
        expectedExceptions = IllegalArgumentException.class)
    void calculateWithNegativeInputs() {
        TriangleArea.calculate(-4, -5);
    }
}
