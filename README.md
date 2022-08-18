# Tournament
## Overiew

There is a sports tournament in which you need to know which player has scored the most points. or Most Valuable Player (MVP).
The results of the matches will be received through files. Each one of them will receive the name of the sport in the first line and the following ones will be the score of the different players together with their data, the only way to recognize the player is by his nickname.
the only way to recognize the player is by his nickname.

Currently only Handball and Basketball games are played but more may be added in the future.

For scoring, the multipliers of the sport table will be applied and 10 extra points will be given to each player if his team has won that match.

For example:

### Basketball:

Each row will represent one player stats, with the format:
````text
player name;nickname;number;team name;position;scored points;rebounds;assists
````

```
BASKETBALL
player 1;nick1;4;Team A;G;10;2;7
player 2;nick2;8;Team A;F;0;10;0
player 3;nick3;15;Team A;C;15;10;4
player 4;nick4;16;Team B;G;20;0;0
player 5;nick5;23;Team B;F;4;7;7
player 6;nick6;42;Team B;C;8;10;0
```

This table details the rating points each player in a basketball match receives depending on his position:

Scored point Rebound Assist
````aidl
Guard   (G) 2 3 1
Forward (F) 2 2 2
Center  (C) 2 1 3
````


E.g. a player playing as center with 10 scored points, 5 rebounds and no assists will be granted 25 rating
points (10*2 + 5*1 + 0*3 ).

The winner team is the one with more scored points.

If there is any error in the reading of the program, the result of the application will not be generated.

### Handball:

Each row will represent one player stats, with the format:
player name;nickname;number;team name;position;goals made;goals received
This table details the rating points each player in a handball match receives depending on his position:
Initial rating points Goal made Goal received

````text
Goalkeeper   (G) 50 5 -2
Field player (F) 20 1 -1
````

E.g. a player playing as goalkeeper with 1 goals made and 10 received will be granted 35 rating points
(50 + 1*5 - 10*2 = 35).
The winner team is the one with more goals made.

Example:
````text
HANDBALL
player 1;nick1;4;Team A;G;0;20
player 2;nick2;8;Team A;F;15;20
player 3;nick3;15;Team A;F;10;20
player 4;nick4;16;Team B;G;1;25
player 5;nick5;23;Team B;F;12;25
player 6;nick6;42;Team B;F;8;25
````

## Technologies
- Architecture: Hexagonal
- Language: Kotlin
- Testing Library: JUnit5
- Automation system: Gradle

## How to...

### The program works
The program uses the reading of files from a known directory to read them and calculate which player has had the most points in the whole tournament.
The program will select all files with the `.txt` extension (example `file.txt`)

you can find them at source
````
main\resources
````
### execute the program?
````
# exec program
kotlin/consoleApp/Program.kt

# makefile with docker 
make build
make run
````

### execute the test?
````
$ .\gradlew test 
````
### Add new sport
1.- Adding the capitalized name to the sports list
```
# Sport.kt
enum class Sport {
    BASKETBALL, HANDBALL, NEWSPORT*
}
```
2.- Modeling the new sport with its scoreboard and properties
```
# RatingPoint.kt
... 
data class NewsportRatingPoint(
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
....
```
3.- Add the new object in the file translation
```
MatchConstructor.kt
....
 Sport.BASKETBALL -> BasketballRatingPoint(
    scoredPoint = match[5].toInt(),
    rebounds = match[6].toInt(),
    assists = match[7].toInt()
)
Sport.NEWSPORT -> NewsportRatingPoint(
    goalMade = match[5].toInt(),
    goalReceived = match[6].toInt()
)
...
```
