package advent

import java.io.File

class Day3 (test_fname: String, puzzle_fname: String) : Runner(test_fname, puzzle_fname) {
    /**
     * parse into lines
     */
    fun parseInputFile(fname: String) : List<String> {
        return File(fname).readLines()
    }

    /**
     * given a sequence of boolean integers as strings, determine the most common bit per row
     */
    fun getMostCommon(lines: List<String>, pos: Int): Char {
        return if (lines.map { it[pos] }.count {it == '1'} >= (lines.size.toDouble() / 2.0)) '1' else '0'
    }

    override fun part1(fname: String) {
        val lines = parseInputFile(fname)
        val length = lines[0].length
        val mostCommon = (0 until length).map {getMostCommon(lines, it)}.joinToString("")
        val mostCommonNum = mostCommon.toLong(2)
        val leastCommon = mostCommon.map { if (it == '0') '1' else '0' }.joinToString("")
        val leastCommonNum = leastCommon.toLong(2)
        println("The Solution is: ${leastCommonNum * mostCommonNum}")
    }

    override fun part2(fname: String) {
        val lines = parseInputFile(fname)
        val length = lines[0].length
        var mostCommon = (0 until length).map {getMostCommon(lines, it)}.joinToString("")
        val leastCommon = mostCommon.map { if (it == '0') '1' else '0' }.joinToString("")

        // get oxygen value
        var oxyLines = lines
        for (idx in (0 until mostCommon.length)) {
            if (oxyLines.size == 1)
                break
            val bit = getMostCommon(oxyLines, idx)
            oxyLines = oxyLines.filter { it[idx] == bit }
        }
        val oxygen = oxyLines[0].toLong(2)

        // get scrub value
        var scrubLines = lines
        for (idx in (0 until mostCommon.length)) {
            if (scrubLines.size == 1)
                break
            val bit = if (getMostCommon(scrubLines, idx) == '1') '0' else '1'
            scrubLines = scrubLines.filter { it[idx] == bit }
        }
        val scrub = scrubLines[0].toLong(2)

        println("The Solution is: ${scrub * oxygen}")
    }
}