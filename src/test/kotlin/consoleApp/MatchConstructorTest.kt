package consoleApp

import matchHandball
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import player1TeamAStatsBasket
import tournament.domain.sport.Sport
import tournament.domain.Match
import java.security.InvalidParameterException

internal class MatchConstructorTest {
    @Test
    fun `When generate stats with bad head then no generate it`() {
        val list: List<String> = listOf(
            "KK", "player 1;nick1;4;Team A;G;10;2;7",
            "player 2;nick2;8;Team A;F;0;10;0",
            "player 3;nick3;15;Team A;C;15;10;4",
            "player 4;nick4;16;Team B;G;20;0;0",
            "player 5;nick5;23;Team B;F;4;7;7",
            "player 6;nick6;42;Team B;C;8;10;0"
        )

        assertThrows<InvalidParameterException> {MatchConstructor().generate(matchFileText = list)  }
    }

    @Test
    fun `knows how generate BASKETBALL match stats`() {
        val list: List<String> = listOf(
            "BASKETBALL",
            "player 1;nick1;4;Team A;G;10;2;7"
        )

        val basketballMatch = MatchConstructor().generate(matchFileText = list)

        assertEquals(
            Match(
                name = Sport.BASKETBALL,
                playerStats = listOf(
                    player1TeamAStatsBasket
                )
            ), basketballMatch
        )

    }

    @Test
    fun `knows how generate HANDBALL match stats`() {
        val list: List<String> = listOf(
            "HANDBALL",
            "player 1;nick1;4;Team A;G;0;20"
        )

        val basketballMatch = MatchConstructor().generate(matchFileText = list)

        assertEquals(matchHandball, basketballMatch)

    }
}