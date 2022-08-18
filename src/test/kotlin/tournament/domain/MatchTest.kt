package tournament.domain

import matchBasketball
import org.junit.jupiter.api.Test
import player1TeamAPlayerPositionG
import player2TeamAPlayerPositionF
import player4TeamBPlayerPositionG
import tournament.domain.player.PlayerScore
import kotlin.test.assertEquals

internal class MatchTest {
    @Test
    fun winterTeam() {
        assertEquals("Team A", matchBasketball.winnerTeam())
    }

    @Test
    fun rankingByPlayers() {
        assertEquals(
            listOf(
                PlayerScore(player = player1TeamAPlayerPositionG, score = 43),
                PlayerScore(player = player4TeamBPlayerPositionG, score = 40),
                PlayerScore(player = player2TeamAPlayerPositionF, score = 30)
            ), matchBasketball.rankingByPlayers()
        )
    }
}

