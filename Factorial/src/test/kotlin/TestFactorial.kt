import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import java.io.File
import java.io.InputStream
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestFactorialBasics {
    @TestFactory
    fun testAllCorrectNumbers(): Collection<DynamicTest> {
        val inputStream: InputStream = File("TestData.txt").inputStream()
        var sourceData = arrayOf<String>()

        inputStream.bufferedReader().forEachLine { sourceData += it }

        return (0..100).map {
            dynamicTest("Test of number $it") {
                assertEquals(getFactorial(arrayOf(it.toString())), sourceData[it].toBigInteger())
            }
        }.toList()
    }
}

class TestFactorialExceptions {
    @TestFactory
    fun testAllIncorrectEnter(): Collection<DynamicTest> {
        val sourceData = arrayOf(-1,101,1000,"abcd",5.5)
        return sourceData.map {
            dynamicTest("Test of number $it") {
                assertFailsWith<Exception> {
                    getFactorial(arrayOf(it.toString()))
                }
            }
        }.toList()
    }

    @Test
    fun testEnterMoreThanOneArg() {
        assertFailsWith<Exception> {
            getFactorial(arrayOf("0","21"))
        }
    }

    @Test
    fun testEnterZeroArg() {
        assertFailsWith<Exception> {
            getFactorial(arrayOf())
        }
    }
}