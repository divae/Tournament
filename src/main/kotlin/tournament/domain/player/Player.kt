package tournament.domain.player

data class Player(
    val name: String,
    val nickname: String,
    val number: Int,
    val teamName: String,
    val playerPosition: PlayerPosition,
)