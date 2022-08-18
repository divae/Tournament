package tournament.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import player1TeamAStatsBasket
import player1TeamAStatsHandball

internal class SportStatsTest {
    @Test
    fun `knows finally points in Basketball`() {
        assertEquals(33, player1TeamAStatsBasket.score())
    }

    @Test
    fun `knows finally points in Handball`() {
        assertEquals(48, player1TeamAStatsHandball.score())
    }

    @Test
    fun `When his team wins then sum 10`() {
        assertEquals(43, player1TeamAStatsBasket.score(true))
    }
}

