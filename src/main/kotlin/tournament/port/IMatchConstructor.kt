package tournament.port

import tournament.domain.Match

interface IMatchConstructor {
    fun generate(matchFileText: List<String>): Match
}