package advent
import java.io.File

/**
 * submarine sonar puzzle
 *
 * the goal is to figure out how quickly the depth increases, just so you know what you're dealing with
 */
class Day1 (test_fname: String, puzzle_fname: String) : Runner(test_fname, puzzle_fname) {
    /**
     *  sign function for integers
     *  TODO: we should probably use some standard function
     * @param x function to apply sign
     */
    fun sign(x : Int) : Int {
        return when {
            (x == 0) -> 0
            (x < 0) -> -1
            else -> 1
        }
    }

    /**
     *  load things as a list of integers (time signal)
     *  @param fname: puzzle input fname
     */
    fun parseInputFile(fname: String) : List<Int> {
        return File(fname).readLines().map { Integer.valueOf(it) }
    }

    /* implement part 1 solution */
    override fun part1(fname: String) {
        val signal = parseInputFile(fname)
        val filtered_signal = (0 until signal.size - 1).map {sign(signal[it + 1] - signal[it])}
        val count = filtered_signal.count {it == 1}
        println("The solution is: $count")
    }

    /* implement part 2 solution */
    override fun part2(fname: String) {
        /* get the input signal */
        val signal = parseInputFile(fname)

        /* get the windows for analysis */
        val windowsa = (0 until signal.size - 2).map {signal.slice(it until it + 3)}
        val windowsb = (1 until signal.size - 2).map {signal.slice(it until it + 3)}

        /* iterate over then together and apply rule */
        val count = windowsb.zip(windowsa).map { when {
            it.first.sum() > it.second.sum() -> 1
            else -> -1
        } } .count {it == 1}
        println("The solution is: $count")
    }
}