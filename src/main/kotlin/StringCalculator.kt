class StringCalculator {
    fun add(input: String) =
        input.removeDelimiter()
            .ifEmpty { "0" }
            .split(getDelimiter(input), "\n")
            .map { it.toInt() }
            .allowOnlyPositives()
            .filter{ it < 1000 }
            .sum()


    private fun List<Int>.allowOnlyPositives(): List<Int>  {

        val negativeNumbers = filter { it < 0 }
        if(negativeNumbers.isNotEmpty())
            throw Exception("negatives not allowed: ${negativeNumbers.joinToString("," )}")

        return this
    }

    private fun String.removeDelimiter() = if (hasDelimiter(this)) this.substring(4) else this

    private fun getDelimiter(input: String) = if(hasDelimiter(input))  input[2].toString() else ","

    private fun hasDelimiter(input: String) = input.startsWith("//")

}