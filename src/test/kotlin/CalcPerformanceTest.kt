import org.junit.jupiter.api.Test
import kotlin.system.measureNanoTime

class CalcPerformanceTest {
    @Test
    fun testCalc() {
        assert(measureNanoTime { complexCalc() } < 2e9)
    }
}