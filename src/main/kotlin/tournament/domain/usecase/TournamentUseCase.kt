package tournament.domain.usecase

import tournament.port.IReadStats

class TournamentUseCase(
    private val readStats: IReadStats
) : ITournament {
    override fun MVP(): String =
        readStats.generate().flatMap {
            it.rankingByPlayers()
        }.groupBy { it.player.nickname }
            .map { PlayerTournamentScore(it.key, it.value.sumOf { it.score }) }.maxByOrNull { it.score }?.nickname
            ?: "No winner"

    private data class PlayerTournamentScore(
        val nickname: String,
        val score: Int
    )
}

