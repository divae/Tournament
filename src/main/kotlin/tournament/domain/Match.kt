package tournament.domain

import tournament.domain.player.PlayerScore
import tournament.domain.sport.Sport
import tournament.domain.sport.SportStats

data class Match(
    val name: Sport,
    val playerStats: List<SportStats>
) {
    fun winnerTeam(): String = playerStats.let { stat ->
        stat.groupBy { it.player.teamName }.map { TeamScore(it.key, it.value.sumOf { it.score() }) }
    }.maxByOrNull { it.score }?.team ?: "No winner"

    fun rankingByPlayers(): List<PlayerScore> = playerStats.map {
        PlayerScore(it.player, it.score(it.player.teamName == winnerTeam()))
    }.sortedByDescending { it.score }

}

