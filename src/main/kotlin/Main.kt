/**
 * AoC 2021 Application
 */
import advent.Day1
import advent.Day2
import advent.Day3
import advent.Day5
import advent.Day7
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.*
import com.github.ajalt.clikt.parameters.types.int

/**
 * CLI Argument Parser
 */
class AoCCommand : CliktCommand(help = "Advent of Code CLI") {
    val day by option(help="Day to Run").int().default(1)
    val inputDirectory by option(help="Inputs Directory").default("inputs")

    override fun run() {
        println("Running Advent of Code Solver for Day $day")
        val test_fname = "test.txt"
        val puzzle_fname = "puzzle.txt"
        when {
            day == 1 -> Day1(test_fname = "$inputDirectory/01/$test_fname", puzzle_fname = "$inputDirectory/01/$puzzle_fname").runAll()
            day == 2 -> Day2(test_fname = "$inputDirectory/02/$test_fname", puzzle_fname = "$inputDirectory/02/$puzzle_fname").runAll()
            day == 3 -> Day3(test_fname = "$inputDirectory/03/$test_fname", puzzle_fname = "$inputDirectory/03/$puzzle_fname").runAll()
            day == 4 -> Day3(test_fname = "$inputDirectory/04/$test_fname", puzzle_fname = "$inputDirectory/04/$puzzle_fname").runAll()
            day == 5 -> Day5(test_fname = "$inputDirectory/05/$test_fname", puzzle_fname = "$inputDirectory/05/$puzzle_fname").runAll()
            day == 7 -> Day7(test_fname = "$inputDirectory/07/$test_fname", puzzle_fname = "$inputDirectory/07/$puzzle_fname").runAll()
            else -> println("No entry for day $day")
        }
    }
}

/**
 * Advent of Code Entrypoint
 */
fun main(args: Array<String>) {
    AoCCommand().main(args)
}