package tournament.domain

import tournament.domain.player.PlayerPosition

sealed interface IRatingPoint {
    fun score(playerPosition: PlayerPosition, teamWinner: Boolean): Int
}

data class BasketballRatingPoint(
    val scoredPoint: Int,
    val rebounds: Int,
    val assists: Int,
) : IRatingPoint {
    private val scoreboard: Map<PlayerPosition, List<Int>> = mapOf(PlayerPosition.G to listOf(2, 3, 1), PlayerPosition.F to listOf(2, 2, 2), PlayerPosition.C to listOf(2, 1, 3))
    override fun score(playerPosition: PlayerPosition, teamWinner: Boolean): Int {
        val recount =
            scoredPoint * scoreboard[playerPosition]!![0] + rebounds * scoreboard[playerPosition]!![1] + assists * scoreboard[playerPosition]!![2]
        return if (teamWinner) recount + 10 else recount
    }
}

data class HandballRatingPoint(
    val goalMade: Int,
    val goalReceived: Int,
) : IRatingPoint {
    private val scoreboard: Map<PlayerPosition,List<Int>> = mapOf(PlayerPosition.G to listOf(50, 5, -2), PlayerPosition.F to listOf(20, 1, -1))
    override fun score(playerPosition: PlayerPosition, teamWinner: Boolean): Int {
        val recount =
            scoreboard[playerPosition]!![0] + goalMade * scoreboard[playerPosition]!![1] + scoreboard[playerPosition]!![2]
        return if (teamWinner) recount + 10 else recount
    }
}
