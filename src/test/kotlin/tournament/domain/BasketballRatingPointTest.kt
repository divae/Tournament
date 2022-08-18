package tournament.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import tournament.domain.player.PlayerPosition

internal class BasketballRatingPointTest {

    @Test
    fun getScoreByBasketball() {
        assertEquals(25, BasketballRatingPoint(10, 5, 0).score(PlayerPosition.C, false))
    }
}