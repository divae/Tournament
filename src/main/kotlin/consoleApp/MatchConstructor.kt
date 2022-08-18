package consoleApp

import tournament.domain.*
import tournament.domain.sport.Sport
import tournament.domain.player.Player
import tournament.domain.player.PlayerPosition
import tournament.domain.sport.SportStats
import tournament.port.IMatchConstructor
import java.security.InvalidParameterException


class MatchConstructor : IMatchConstructor {
    override fun generate(matchFileText: List<String>): Match {
        try {
            val sportType = Sport.valueOf(matchFileText[0].uppercase())
            val stats = matchFileText.drop(1)
            val playerStats: MutableList<SportStats> = mutableListOf()

            for (line in stats) {
                val match = line.split(";").toTypedArray()
                playerStats.add(
                    SportStats(
                        Player(
                            name = match[0],
                            nickname = match[1],
                            number = match[2].toInt(),
                            teamName = match[3],
                            playerPosition = PlayerPosition.valueOf(match[4])
                        ),
                        rating = when (sportType) {
                            Sport.BASKETBALL -> BasketballRatingPoint(
                                scoredPoint = match[5].toInt(),
                                rebounds = match[6].toInt(),
                                assists = match[7].toInt()
                            )

                            Sport.HANDBALL -> HandballRatingPoint(
                                goalMade = match[5].toInt(),
                                goalReceived = match[6].toInt()
                            )
                        }
                    )
                )
            }
            return Match(
                name = sportType, playerStats = playerStats
            )
        } catch (e: Exception) {
            throw InvalidParameterException("Error when reading the file")
        }
    }

}


