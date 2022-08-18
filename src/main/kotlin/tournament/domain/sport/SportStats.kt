package tournament.domain.sport

import tournament.domain.IRatingPoint
import tournament.domain.player.Player

data class SportStats(
    val player: Player,
    val rating: IRatingPoint
) {
    fun score(teamWinner: Boolean = false): Int = rating.score(player.playerPosition, teamWinner)
}
