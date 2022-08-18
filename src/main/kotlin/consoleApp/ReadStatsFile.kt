package consoleApp

import tournament.domain.Match
import tournament.port.IReadStats
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.io.path.bufferedReader

class ReadStatsFile : IReadStats {
    override fun generate(): List<Match> {
        val matches: MutableList<Match> = mutableListOf()
        val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val resourcesPath = Paths.get(projectDirAbsolutePath, "/src/main/resources")
        Files.walk(resourcesPath)
            .filter { item -> Files.isRegularFile(item) }
            .filter { item -> item.toString().endsWith(".txt") }
            .forEach { item ->
                val bufferedReader = item.bufferedReader()
                val text: List<String> = bufferedReader.readLines()
                val match = MatchConstructor().generate(text)
                matches.add(match)
            }

        return matches
    }
}

