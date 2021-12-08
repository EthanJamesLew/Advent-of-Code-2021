package advent

import java.io.File
import kotlin.math.absoluteValue

/**
 * Lantern Fish Population
 */
class Day6 (test_fname: String, puzzle_fname: String) : Runner(test_fname, puzzle_fname) {
    fun parseInputFile(fname: String) : IntArray {
        return File(fname).readLines()[0].split(",").map {it.toInt()}.toIntArray()
    }

    /**
     * do the population math for the puzzle
     *
     * needs to be long because of overflow issue
     */
    fun getNumFishes(fishes: IntArray, nDays: Int): Long {
        var days = LongArray(9)
        for (fish in fishes) {
            days.set(fish, days.get(fish) + 1)
        }
        for (idx in 0 until nDays) {
            val today = idx % days.size
            days[(today + 7) % days.size] += days[today]
        }
        return days.sum()
    }

    override fun part1(fname: String) {
        val fishes = parseInputFile(fname)
        println("The Solution is: ${getNumFishes(fishes, 80)}")
    }

    override fun part2(fname: String) {
        val fishes = parseInputFile(fname)
        println("The Solution is: ${getNumFishes(fishes, 256)}")
    }

}