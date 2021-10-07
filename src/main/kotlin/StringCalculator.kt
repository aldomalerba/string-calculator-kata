class StringCalculator {
    fun add(input: String) : Int =
        input.ifEmpty { "0" }.split(",", "\n").sumOf(String::toInt)
}
