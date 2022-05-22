import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import java.io.File
import java.io.InputStream
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestsNum2WordBasics {
    @TestFactory
    fun testAllCorrectNumbers(): Collection<DynamicTest> {
        val inputStream: InputStream = File("TestData.txt").inputStream()
        var sourceData = arrayOf<String>()

        inputStream.bufferedReader().forEachLine { sourceData += it }

        return (1..1000).map {
            dynamicTest("Test of number $it") {
                assertEquals(getWordsByNum(arrayOf(it.toString())), sourceData[it-1])
            }
        }.toList()
    }
}

class TestsNum2WordExceptions {
    @TestFactory
    fun testEnterIncorrectInput(): Collection<DynamicTest> {
        val sourceArray = arrayOf(-1, 12000, 12.4, "abs")
        return sourceArray.map {
            dynamicTest("Test of number $it") {
                assertFailsWith<Exception> {
                    getWordsByNum(arrayOf(it.toString()))
                }
            }
        }.toList()
    }

    @Test
    fun testEnterMoreThanOneArg() {
        assertFailsWith<Exception> {
            getWordsByNum(arrayOf("123","21"))
        }
    }

    @Test
    fun testEnterZeroArg() {
        assertFailsWith<Exception> {
            getWordsByNum(arrayOf())
        }
    }
}