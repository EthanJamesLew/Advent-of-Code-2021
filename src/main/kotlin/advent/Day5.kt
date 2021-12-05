package advent

import java.io.File
import kotlin.math.roundToInt

class Day5 (test_fname: String, puzzle_fname: String) : Runner(test_fname, puzzle_fname) {

    /**
     * parse into lines
     */
    fun parseInputFile(fname: String) : List<Pair<Pair<Int, Int>, Pair<Int, Int>>> {
        val splits =  File(fname).readLines()
            .map {it.split(" -> ")}
        val points_list = splits.map {
            it.map{
                Pair(
                    first=Integer.valueOf(it.split(",")[0]),
                    second=Integer.valueOf(it.split(",")[1])
                )
            }
        }
        val points_pairs = points_list.map {Pair(first = it[0], second = it[1])}
        return points_pairs
    }

    /**
     * Given two endpoints on a line and the line is either horizontal or vertical,
     * return the coordinates for each integer point on the line
     */
    fun getCoordsP1(point_pair: Pair<Pair<Int, Int>, Pair<Int, Int>>): List<Pair<Int, Int>> {
        val  xmin = kotlin.math.min(point_pair.first.first, point_pair.second.first)
        val  xmax = kotlin.math.max(point_pair.first.first, point_pair.second.first)
        val  ymin = kotlin.math.min(point_pair.first.second, point_pair.second.second)
        val  ymax = kotlin.math.max(point_pair.first.second, point_pair.second.second)
        return when {
            ymin == ymax -> {(xmin .. xmax).map {Pair(first = ymin, second = it)}}
            xmin == xmax -> {(ymin .. ymax).map {Pair(first = it, second = xmin)}}
            else ->  emptyList<Pair<Int, Int>>()
        }
    }

    /**
     * extend the getCoords function to work with 45 degree angle lines
     */
    fun getCoordsP2(point_pair: Pair<Pair<Int, Int>, Pair<Int, Int>>): List<Pair<Int, Int>> {
        // get difference between two endpoints
        val diff = Pair<Int, Int>(
            first = point_pair.second.first - point_pair.first.first,
            second = point_pair.second.second - point_pair.first.second
        )
        // get the length of the line
        val dist = kotlin.math.sqrt((diff.first * diff.first + diff.second * diff.second).toDouble())
        val idist = (dist).roundToInt()

        // normalize the difference vector
        val ndiff = Pair<Int, Int>(
            first = ((diff.first).toDouble() / dist).roundToInt(),
            second = ((diff.second).toDouble() / dist).roundToInt()
        )

        //println("${dist} ${ndiff} ${point_pair.first} ${point_pair.second}")
        return (0 .. idist).map {
            Pair<Int, Int>(
                first = point_pair.first.first + (ndiff.first * it),
                second = point_pair.first.second + (ndiff.second * it)
            )
        }
    }

    override fun part1(fname: String) {
        val inputs = parseInputFile(fname)
        val points = inputs.map {getCoordsP1(it)} .reduce {a, b -> a + b}
        val counts = points.groupingBy { it }.eachCount().filter { it.value > 1 }
        println("The Solution is: ${counts.size}")
    }

    override fun part2(fname: String) {
        val inputs = parseInputFile(fname)
        val points = inputs.map {getCoordsP2(it)} .reduce {a, b -> a + b}
        val counts = points.groupingBy { it }.eachCount().filter { it.value > 1 }
        println("The Solution is: ${counts.size}")
    }
}