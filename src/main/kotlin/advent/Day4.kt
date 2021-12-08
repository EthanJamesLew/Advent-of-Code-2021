package advent

import java.io.File

class Day4 (test_fname: String, puzzle_fname: String) : Runner(test_fname, puzzle_fname) {
    fun parseInputFile(fname: String): Pair<IntArray, Array<Bingo>> {
        val inLines = File(fname).readLines()
        val guesses = inLines[0].split(',').map {it.toInt()}.toIntArray()
        val board_len = 6
        val nboards = (inLines.size - 1) / board_len
        val boards = (0 until nboards)
            .map {inLines.slice(it * board_len + 2 until (it + 1) * board_len + 1)}
            .map {
                Bingo(
                    it
                        .map { i -> i.strip().split(Regex("\\s+")).map{ i -> i.toInt()}.toIntArray()}
                        .toTypedArray()
                )}
            .toTypedArray()
        return Pair(first = guesses, second = boards)
    }

    override fun part1(fname: String) {
        val inp = parseInputFile(fname)
        val guesses = inp.first; val boards = inp.second
        for (idx in 0 until guesses.size) {
            val currGuesses = guesses.slice(0 until idx)
            val won = boards.map {board -> board.submitGuesses(currGuesses.toIntArray())}
            if (won.all {it == true}) {
                TODO("Not yet implemented")
            }
        }
    }

    override fun part2(fname: String) {
        TODO("Not yet implemented")
    }
}
