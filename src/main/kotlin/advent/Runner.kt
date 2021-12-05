package advent

/**
 * Advent of Code Runner
 *
 * Execute the steps necessary to test the code on the example case as well as
 * the puzzle input.
 */
abstract class Runner (
    val test_fname: String,
    val puzzle_fname: String
)
{
    /* solution to part 1 */
    abstract fun part1(fname: String)

    /* solution to part 2 */
    abstract fun part2(fname: String)

    fun runPart1(fname: String) {
        println("Running Part 1 on $fname...")
        part1(fname)
        println("Finished Part 1!")
    }

    fun runPart2(fname: String) {
        println("Running Part 2 on $fname...")
        part2(fname)
        println("Finished Part 2!")
    }

    fun runTest() {
        runPart1(test_fname)
        runPart2(test_fname)
    }

    fun runPuzzle() {
        runPart1(puzzle_fname)
        runPart2(puzzle_fname)
    }

    fun runAll() {
        println("Running Advent Runner...")
        runTest()
        runPuzzle()
        println("Finished All!")
    }
}