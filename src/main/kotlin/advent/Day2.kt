package advent

import java.io.File

/**
 * submarine course puzzle
 *
 * The submarine seems to already have a planned course (your puzzle input).
 * You should probably figure out where it's going.
 */
class Day2 (test_fname: String, puzzle_fname: String) : Runner(test_fname, puzzle_fname) {
    /**
     * parse into instruction, value pairs
     */
    fun parseInputFile(fname: String) : List<Pair<String, Int>> {
        return File(fname).readLines()
            .map { it.split(" ")}
            .map {Pair<String, Int>(first = it[0], second = Integer.valueOf(it[1]))}
    }

    override fun part1(fname: String) {
        val pairs = parseInputFile(fname)
        val x = pairs.filter { it.first == "up" || it.first == "down" }
            .map{ when {
                it.first == "up" -> -it.second
                it.first == "down" -> it.second
                else -> 0
            }}.sum()
        val y = pairs.filter { it.first == "forward" }
            .map{ it.second }.sum()
        println("The solution is: ${x * y}")
    }

    override fun part2(fname: String) {
        val pairs = parseInputFile(fname)
        var x  = 0; var y =0; var aim = 0;
        for ((instr, ival) in pairs) {
            when {
                instr == "up" -> aim -= ival
                instr == "down" -> aim += ival
                instr == "forward" -> {x += ival; y += aim * ival}
            }
        }
        println("The solution is: ${x * y}")
    }
}