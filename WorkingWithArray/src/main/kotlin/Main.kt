fun main(args: Array<String>) {
    val newArray = makeNewArray(args)
}

fun isArgsCorrect(strings: Array<String>): Boolean {
    for(elem in strings)
        if(elem.toDoubleOrNull()==null)
            return false

    return true
}

fun makeNewArray(strings: Array<String>): Array<Double> {
    if(!isArgsCorrect(strings)) throw Exception("Please enter correct array")

    val sourceArray: Array<Double> = strings.map { it.toDouble() }.toTypedArray()
    var cntNegs = 0
    var answerArray = arrayOf<Double>()

    for(elem in sourceArray) {
        if(elem >= 0 || answerArray.isEmpty()) {
            answerArray += elem
        } else {
            answerArray += answerArray[cntNegs]
            answerArray[cntNegs] = elem
            ++cntNegs
        }
    }

    return answerArray
}