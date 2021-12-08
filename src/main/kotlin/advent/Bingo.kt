package advent

/**
 * Bingo board
 */
class Bingo (var board: Array<IntArray>) {
    /**
     * submit a list of guesses and determine if win happens
     */
    fun submitGuesses(guess: IntArray): Boolean {
        for (rowidx in 0 until board.size) {
            val row = board[rowidx]
            val row_set = row.toSet()
            if (guess.toSet().containsAll(row_set)) {
                return true
            }
        }
        for (colidx in 0 until board[0].size) {
            val col = board.map {it[colidx]}
            val col_set = col.toSet()
            if (guess.toSet().containsAll(col_set)) {
                return true
            }
        }
        return false
    }
}