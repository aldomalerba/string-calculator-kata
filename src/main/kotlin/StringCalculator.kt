class StringCalculator {
    fun add(input: String) : Int {
        return input.removeDelimiter()
            .ifEmpty { "0" }
            .split(getDelimiter(input), "\n")
            .sumOf(String::toInt)
    }

    private fun String.removeDelimiter() = if (hasDelimiter(this)) this.substring(4) else this

    private fun getDelimiter(input: String) = if(hasDelimiter(input))  input[2].toString() else ","

    private fun hasDelimiter(input: String) = input.startsWith("//")

}
