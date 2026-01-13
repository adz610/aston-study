import org.example.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest extends Assert {
    @DataProvider(name = "Тестовые данные")
    Object[][] getInputs() {
        return new Object[][] {
            {5, 5},
            {1, -1},
            {0, 0},
            {-5, -5}
        };
    }

    @Test(description = "Сложение",
        dataProvider = "Тестовые данные")
    void addition(int a, int b) {
        assertEquals(Calculator.add(a, b), a + b);
    }

    @Test(description = "Вычитание",
        dataProvider = "Тестовые данные")
    void subtraction(int a, int b) {
        assertEquals(Calculator.subtract(a, b), a - b);
    }

    @Test(description = "Умножение",
        dataProvider = "Тестовые данные")
    void multiplication(int a, int b) {
        assertEquals(Calculator.multiply(a, b), a * b);
    }

    @Test(description = "Деление",
        dataProvider = "Тестовые данные")
    void division(int a, int b) {
        try {
            int result = Calculator.divide(a, b);
            assertEquals(result, a / b);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Деление на ноль недопустимо");
        }
    }
}
