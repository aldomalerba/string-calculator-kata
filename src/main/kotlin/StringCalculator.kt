class StringCalculator {
    fun add(input: String) : Int {
        val numbers = input.removeDelimiter()
            .ifEmpty { "0" }
            .split(getDelimiter(input), "\n")
            .map { it.toInt() }

        val negativeNumbers = numbers.filter { it < 0 }
        if(negativeNumbers.isNotEmpty())
            throw Exception("negatives not allowed: ${negativeNumbers.joinToString("," )}")
        else return numbers.sum()
    }

    private fun String.removeDelimiter() = if (hasDelimiter(this)) this.substring(4) else this

    private fun getDelimiter(input: String) = if(hasDelimiter(input))  input[2].toString() else ","

    private fun hasDelimiter(input: String) = input.startsWith("//")

}
