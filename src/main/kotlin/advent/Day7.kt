package advent

import java.io.File
import kotlin.math.absoluteValue

/**
 * Best Hoizontal Position for Crab Submarines
 */
class Day7 (test_fname: String, puzzle_fname: String) : Runner(test_fname, puzzle_fname) {
    fun parseInputFile(fname: String) : IntArray {
        return File(fname).readLines()[0].split(",").map {it.toInt()}.toIntArray()
    }

    /**
     * formula to calculate sum of 0 .. N
     */
    fun sumRange(n: Int) : Int {
        return (n + 1) * n / 2
    }

    /**
     * best position for constant fuel burn
     */
    override fun part1(fname: String) {
        val inp = parseInputFile(fname)
        val fuelPerSub = (0 ..inp.maxOrNull()!!).map { pos ->
            inp.map { subDist ->
                (subDist - pos).absoluteValue
            }.sum()
        }
        println("The Solution Is: ${fuelPerSub.minOrNull()}")
    }

    /**
     * best position for linear fuel burn
     */
    override fun part2(fname: String) {
        val inp = parseInputFile(fname)
        val fuelPerSub = (0 ..inp.maxOrNull()!!).map { pos ->
            inp.map { subDist ->
                sumRange((subDist - pos).absoluteValue)
            }.sum()
        }
        println("The Solution Is: ${fuelPerSub.minOrNull()}")
    }
}