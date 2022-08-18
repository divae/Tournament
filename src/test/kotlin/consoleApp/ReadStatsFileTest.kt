package consoleApp

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


internal class ReadStatsFileTest {

    @Test
    fun `Generate Sports by file`() {
        Assertions.assertEquals(2, ReadStatsFile().generate().count())
    }
}