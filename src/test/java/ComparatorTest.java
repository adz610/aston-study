import org.example.Comparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComparatorTest {
    @DisplayName("Сравнение двух одинаковых чисел")
    @Test
    void compareIdenticalNumbers() {
        assertTrue(Comparator.compare(1, 1));
    }

    @DisplayName("Сравнение двух отличающихся чисел")
    @Test
    void compareDifferentNumbers() {
        assertFalse(Comparator.compare(1, 0));
    }
}
