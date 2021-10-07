import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
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

    @Test
    internal fun `sum numbers`() {

        assertEquals(3, StringCalculator().add("1,2"))
        assertEquals(16, StringCalculator().add("12,4"))
        assertEquals(6, StringCalculator().add("1,2,3"))
        assertEquals(27, StringCalculator().add("12,4,11"))

    }

    @Test
    internal fun `handle new lines between numbers`() {
        assertEquals(6, StringCalculator().add("1\n2,3"))
        assertEquals(28, StringCalculator().add("12\n4\n11\n1"))
    }

    @Test
    internal fun `support different delimiters`() {
        assertEquals(6, StringCalculator().add("//;\n1;2;3"))
        assertEquals(28, StringCalculator().add("//m\n12m4m11\n1"))
    }

    @Test
    internal fun `negative numbers throw an exception`() {

        val exception = assertThrows<Exception> { StringCalculator().add("2,-1,-3") }
        assertEquals("negatives not allowed: -1,-3", exception.message)

    }
}