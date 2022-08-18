import tournament.domain.*
import tournament.domain.sport.Sport
import tournament.domain.player.Player
import tournament.domain.player.PlayerPosition
import tournament.domain.sport.SportStats

val player1TeamAPlayerPositionG = Player(
    name = "player 1",
    nickname = "nick1",
    number = 4,
    teamName = "Team A",
    playerPosition = PlayerPosition.G
)
val player1TeamAStatsBasket = SportStats(
    player = player1TeamAPlayerPositionG,
    BasketballRatingPoint(
        scoredPoint = 10,
        rebounds = 2,
        assists = 7
    )
)


val player4TeamBPlayerPositionG = Player(
    name = "player 4",
    nickname = "nick4",
    number = 16,
    teamName = "Team B",
    playerPosition = PlayerPosition.G
)
val player2TeamAPlayerPositionF = Player(
    name = "player 2",
    nickname = "nick2",
    number = 8,
    teamName = "Team A",
    playerPosition = PlayerPosition.F
)
val matchBasketball = Match(
    name = Sport.BASKETBALL,
    playerStats = listOf(
        player1TeamAStatsBasket,
        SportStats(
            player2TeamAPlayerPositionF,
            BasketballRatingPoint(
                scoredPoint = 0,
                rebounds = 10,
                assists = 0
            )
        ),
        SportStats(
            player4TeamBPlayerPositionG,
            BasketballRatingPoint(
                scoredPoint = 20,
                rebounds = 0,
                assists = 0
            )
        )
    )
)

val player1TeamAStatsHandball = SportStats(
    player1TeamAPlayerPositionG,
    HandballRatingPoint(
        goalMade = 0,
        goalReceived = 20
    )
)
val matchHandball = Match(
    name = Sport.HANDBALL,
    playerStats = listOf(player1TeamAStatsHandball)
)