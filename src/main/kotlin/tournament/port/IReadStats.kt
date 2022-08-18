package tournament.port

import tournament.domain.Match

interface IReadStats {
    fun generate(): List<Match>
}
