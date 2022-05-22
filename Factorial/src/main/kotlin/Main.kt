import java.math.BigInteger

var factorials: Array<BigInteger> = arrayOf(BigInteger.ONE, BigInteger.ONE)

fun main(args: Array<String>) {
    println(getFactorial(args))
}

fun isArgsCorrectNum(strings: Array<String>): Boolean {
    return strings[0].toIntOrNull() != null && strings[0].toInt() in 0..100
}

fun getFactorial(strings: Array<String>): BigInteger {
    if(strings.size!=1) throw Exception("Please enter only one number")
    if(!isArgsCorrectNum(strings)) throw Exception("Please enter an Integer number from [0;100]")

    val argInt = strings[0].toInt()
    if(factorials.size<=argInt) {
        val lastFac = factorials.lastIndex

        for (i in (lastFac..argInt)) {
            factorials += factorials[i] * (i+1).toBigInteger()
        }
    }
    return factorials[argInt]
}