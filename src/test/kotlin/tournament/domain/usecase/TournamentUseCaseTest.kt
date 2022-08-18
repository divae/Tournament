package tournament.domain.usecase

import consoleApp.ReadStatsFile
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TournamentUseCaseTest {

    @Test
    fun `Shows the player name of the MVP`() {
        val playerName = TournamentUseCase(
            readStats = ReadStatsFile()
        ).MVP()

        assertEquals("nick3", playerName)
    }
}