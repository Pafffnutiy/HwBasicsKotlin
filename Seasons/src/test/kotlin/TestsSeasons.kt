import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class TestsSeasonsBasics {
    @TestFactory
    fun testEnterWinterMonthNumber(): Collection<DynamicTest> {
        val months = arrayOf("1","2","12")
        return months.map {
            dynamicTest("Test $it month") {
                assertTrue(getSeason(arrayOf(it))=="Winter")
            }
        }.toList()
    }

    @TestFactory
    fun testEnterSpringMonthNumber(): Collection<DynamicTest> {
        val months = arrayOf("3","4","5")
        return months.map {
            dynamicTest("Test $it month"){
                assertTrue(getSeason((arrayOf(it)))=="Spring")
            }
        }
    }

    @TestFactory
    fun testEnterSummerMonthNumber(): Collection<DynamicTest> {
        val months = arrayOf("6","7","8")
        return months.map {
            dynamicTest("Test $it month"){
                assertTrue(getSeason((arrayOf(it)))=="Summer")
            }
        }
    }

    @TestFactory
    fun testEnterAutumnMonthNumber(): Collection<DynamicTest> {
        val months = arrayOf("9","10","11")
        return months.map {
            dynamicTest("Test $it month"){
                assertTrue(getSeason((arrayOf(it)))=="Autumn")
            }
        }
    }
}

class TestsSeasonsExceptions {
    @Test
    fun testEnterNotNumber(){
        assertFailsWith<Exception> {
            getSeason(arrayOf("someString"))
        }
    }

    @Test
    fun testEnterMoreThanOneArg(){
        assertFailsWith<Exception> {
            getSeason(arrayOf("someString","11"))
        }
    }

    @Test
    fun testEnterLessThanOneArg(){
        assertFailsWith<Exception> {
            getSeason(arrayOf())
        }
    }

    @Test
    fun testEnterNumberOutOfRange(){
        assertFailsWith<Exception> {
            getSeason(arrayOf("15"))
        }
    }
}