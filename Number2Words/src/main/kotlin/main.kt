val digitsWord      = arrayOf("один","два","три","четыре","пять","шесть","семь","восемь","девять")
val tensWord        = arrayOf("десять","одиннадцать","двенадцать","тринадцать","надцать","дцать","сорок","десят","девяносто")
val hundredsWord    = arrayOf("сто","двести","ста","сот")
const val oneThousandWord = "одна тысяча"

fun main(args: Array<String>)
{
    val inputInt = "1000".toInt()
    if (!(inputInt in 1..1000)) throw Exception("Number should be from [1;30]")

    val input = inputInt.toString()

    val digitsByNumber = getDigitsByNumber(input)

    val resultWord = when(digitsByNumber.size){
        1 -> digitsWord[digitsByNumber[0].digitToInt()-1]
        2 -> parseNumWith2digits(digitsByNumber)
        3 -> parseNumWith3digits(digitsByNumber)
        4 -> oneThousandWord
        else -> ""
    }

    println(resultWord)
}

fun parseNumWith2digits(digits: Array<Char>): String
{

    val digit1 = digits[0].digitToInt()
    val digit1Word = if(digit1!=0) digitsWord[digit1-1] else ""
    val digit2 = digits[1].digitToInt()
    val digit2Word = if(digit2!=0) digitsWord[digit2-1] else ""

    val result = when(digit1) {
        0 -> digit2Word
        1 -> when(digit2) {
                0 -> tensWord[0]
                in 1..3 -> tensWord[digit2]
                in 4..9 -> digit2Word.dropLast(1) + tensWord[4]
                else -> ""
            }
        in 2..3 -> digit1Word+tensWord[5]+ ' ' + digit2Word
        4 -> tensWord[6] + ' ' + digit2Word
        in 5..8 -> digit1Word+tensWord[7] + ' ' + digit2Word
        9 -> tensWord[8]+ ' ' + digit2Word
        else -> ""
    }

    return result
}

fun parseNumWith3digits(digits: Array<Char>): String
{

    val result = when(val digit = digits[0].digitToInt()){
        in 1..2 -> hundredsWord[digit-1]
        in 3..4 -> digitsWord[digit-1] +  hundredsWord[2]
        in 5..9 -> digitsWord[digit-1] + hundredsWord[3]
        else -> ""
    }

    return result + ' ' + parseNumWith2digits(arrayOf(digits[1],digits[2]))
}

fun getDigitsByNumber(num: String): Array<Char>
{
    var digitsFromNum = arrayOf<Char>()

    for(elem in num) {
        digitsFromNum = digitsFromNum.plus(elem)
    }

    return digitsFromNum
}