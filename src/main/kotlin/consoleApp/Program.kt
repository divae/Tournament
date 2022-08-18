import consoleApp.ReadStatsFile
import tournament.port.IReadStats
import tournament.domain.usecase.ITournament
import tournament.domain.usecase.TournamentUseCase

fun main() {
    val readStats: IReadStats = ReadStatsFile()
    val tournament: ITournament = TournamentUseCase(
        readStats = readStats
    )
    println("MVP 2022 are: ${tournament.MVP()}")
}