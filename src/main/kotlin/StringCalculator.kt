class StringCalculator {
    fun add(input: String) : Int {
        return (if(input.startsWith("//")) input.substring(4) else input)
        .ifEmpty { "0" }.split(getDelimiter(input), "\n").sumOf(String::toInt)
    }

    private fun getDelimiter(input: String): String {
        if(input.startsWith("//")){
            return input[2].toString()
        }
        return ","
    }

}
