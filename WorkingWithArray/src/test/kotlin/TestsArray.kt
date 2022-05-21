import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class TestsArrayBasics {
    @Test
    fun testAllNegs(){
        val sourceArray = arrayOf("-5.0","-3","-10.1","-1.7")
        val expectingResultArray = arrayOf(-3.0,-10.1,-1.7,-5.0)
        assertTrue(makeNewArray(sourceArray).contentEquals(expectingResultArray))
    }

    @Test
    fun testMixedNumbers() {
        val sourceArray = arrayOf("1", "2.3", "-5", "-4.2", "13.9", "-4.0", "1.1", "-0.5", "0", "0.0")
        val expectingResultArray = arrayOf(-5.0, -4.2, -4.0, -0.5, 13.9, 1.0, 1.1, 2.3, 0.0, 0.0)
        assertTrue(makeNewArray(sourceArray).contentEquals(expectingResultArray))
    }

    @Test
    fun testAllPos() {
        val sourceArray = arrayOf("1.2","3.2","10.1","11.4")
        val expectingResultArray = arrayOf(1.2,3.2,10.1,11.4)
        assertTrue(makeNewArray(sourceArray).contentEquals(expectingResultArray))
    }
}

class TestsArrayExceptions {
    @TestFactory
    fun testEnterIncorrectSourceArray(): Collection<DynamicTest> {
        val goodElems = arrayOf("1.0", "23.0", "-2", "-4.5", "10", "-1000")
        val badElems = arrayOf("abc","1-2","3.+0")
        return badElems.map {
            dynamicTest("Test with \"$it\" as element of array") {
                assertFailsWith<Exception> {
                    makeNewArray(goodElems+it)
                }
            }
        }.toList()
    }
}