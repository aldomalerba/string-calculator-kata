class StringCalculator {
    fun add(input: String) : Int = input.ifEmpty { "0" }.toInt()
}
