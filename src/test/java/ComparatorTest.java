import org.example.Comparator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComparatorTest extends Assert{
    @Test(description = "Сравнение двух одинаковых чисел")
    void compareIdenticalNumbers() {
        assertTrue(Comparator.compare(1, 1));
    }

    @Test(description = "Сравнение двух отличающихся чисел")
    void compareDifferentNumbers() {
        assertFalse(Comparator.compare(1, 0));
    }
}
