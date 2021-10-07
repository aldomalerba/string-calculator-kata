import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StringCalculatorTest {
    @Test
    internal fun `return zero for empty string`() {

        assertEquals(0, StringCalculator().add(""))
    }

    @Test
    internal fun `return single number`() {

        assertEquals(11, StringCalculator().add("11"))
        assertEquals(123, StringCalculator().add("123"))
        assertEquals(3, StringCalculator().add("3"))

    }

}