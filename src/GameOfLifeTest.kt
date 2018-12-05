import org.junit.jupiter.api.Test as test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GameOfLifeTest {
    @test
    fun canCheckAlive() {
        val board = Board(listOf(listOf(true)))
        assertTrue { board.cellIsAlive(0, 0) }
    }

    @test
    fun outOfBoundsIsDead() {
        val board = Board(listOf(listOf(true)))
        assertFalse { board.cellIsAlive(1, 1) }
    }

    @test
    fun countNeighboursForOne() {
        val soloBoard = Board(listOf(listOf(true)))
        assertEquals(soloBoard.countNeighbours(0, 0), 0)
    }

    @test
    fun countNeighboursForHorizontal() {
        val soloBoard = Board(
            listOf(
                listOf(true), listOf(true), listOf(true)
            )
        )
        assertEquals(soloBoard.countNeighbours(1, 0), 2)
    }

    @test
    fun countNeighboursForVertical() {
        val soloBoard = Board(
            listOf(
                listOf(true, true, true)
            )
        )
        assertEquals(soloBoard.countNeighbours(0, 1), 2)
    }
}