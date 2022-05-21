fun main(args: Array<String>) {
    println(getSeason(args))
}

fun getSeason(args: Array<String>): String
{
    if(args.size!=1) throw Exception("Please enter only one number from 1 to 12")

    val enterNumberExcept = Exception("Please enter an integer number from 1 to 12")

    if(!args[0].all { char -> char.isDigit() }) throw enterNumberExcept

    return when(args[0].toInt()){
        in arrayOf(1, 2 , 12) -> "Winter"
        in 3..5 -> "Spring"
        in 6..8 -> "Summer"
        in 9..11 -> "Autumn"
        else -> throw enterNumberExcept
    }
}