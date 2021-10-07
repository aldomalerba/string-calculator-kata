class StringCalculator {
    fun add(input: String) : Int {

        val numbers = input.removeDelimiter()
            .ifEmpty { "0" }
            .split(getDelimiter(input), "\n")
            .map { it.toInt() }
            .filter{ it <= 1000 }

        allowOnlyPositives(numbers)

        return numbers.sum()
    }


    private fun allowOnlyPositives(numbers: List<Int>) {

        val negativeNumbers = numbers.filter { it < 0 }
        if(negativeNumbers.isNotEmpty())
            throw Exception("negatives not allowed: ${negativeNumbers.joinToString("," )}")

    }

    private fun String.removeDelimiter() = if (hasDelimiter(this)) this.substring(4) else this

    private fun getDelimiter(input: String) = if(hasDelimiter(input))  input[2].toString() else ","

    private fun hasDelimiter(input: String) = input.startsWith("//")

}