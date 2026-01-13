import org.example.Factorial;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest extends Assert{

    @Test(description = "Факториал нуля")
    void factorialOfZero() {
        assertEquals(Factorial.calculate(0), 1);
    }

    @Test(description = "Факториал единицы")
    void factorialOfOne() {
        assertEquals(Factorial.calculate(1), 1);
    }

    @Test(description = "Факториал положительного числа больше 1")
    void factorialOfPositiveNumber() {
        assertEquals(Factorial.calculate(5), 120);
    }

    @Test(description = "Факториал отрицательного числа (исключение)",
        expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        Factorial.calculate(-1);
    }
}
