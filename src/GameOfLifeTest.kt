import org.junit.jupiter.api.Test as test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

val ALIVE = true
val DEAD = false

class GameOfLifeTest {
    @test
    fun canCheckAlive() {
        val board = Board(listOf(listOf(ALIVE)))
        assertTrue { board.cellIsAlive(0, 0) }
    }

    @test
    fun outOfBoundsIsDead() {
        val board = Board(listOf(listOf(ALIVE)))
        assertFalse { board.cellIsAlive(1, 1) }
    }

    @test
    fun countNeighboursForOne() {
        val soloBoard = Board(listOf(listOf(ALIVE)))
        assertEquals(soloBoard.countNeighbours(0, 0), 0)
    }

    @test
    fun countNeighboursForHorizontal() {
        val soloBoard = Board(
            listOf(
                listOf(ALIVE), listOf(ALIVE), listOf(ALIVE)
            )
        )
        assertEquals(soloBoard.countNeighbours(1, 0), 2)
    }

    @test
    fun countNeighboursForVertical() {
        val soloBoard = Board(
            listOf(
                listOf(ALIVE, ALIVE, ALIVE)
            )
        )
        assertEquals(soloBoard.countNeighbours(0, 1), 2)
    }

    @test
    fun cellsWithFewerThanTwoNeighboursDie() {
        val soloBoard = Board(
            listOf(
                listOf(ALIVE, ALIVE, DEAD)
            )
        )
        assertEquals(soloBoard.countNeighbours(0, 1), 1)
        soloBoard.evolve()
        assertFalse(soloBoard.cellIsAlive(0, 1))
    }

    @test
    fun cellsWithTwoNeighboursLive() {
        val soloBoard = Board(
            listOf(
                listOf(ALIVE, ALIVE, ALIVE)
            )
        )
        assertEquals(soloBoard.countNeighbours(0, 1), 2)
        soloBoard.evolve()
        assertTrue(soloBoard.cellIsAlive(0, 1))
    }

    @test
    fun cellsWithThreeNeighoursLive() {
        val soloBoard = Board(
            listOf(
                listOf(ALIVE, ALIVE, ALIVE),
                listOf(ALIVE, DEAD, DEAD)

            )
        )
        assertEquals(soloBoard.countNeighbours(0, 1), 3)
        soloBoard.evolve()
        assertTrue(soloBoard.cellIsAlive(0, 1))
    }

    @test
    fun cellsWithMoreThanThreeNeighoursDie() {
        val soloBoard = Board(
            listOf(
                listOf(ALIVE, ALIVE, ALIVE),
                listOf(ALIVE, ALIVE, ALIVE)

            )
        )
        assertEquals(soloBoard.countNeighbours(0, 1), 5)
        soloBoard.evolve()
        assertFalse(soloBoard.cellIsAlive(0, 1))
    }

    @test
    fun deadCellsWithExactly3NeighboursBecomeAlive() {
        val soloBoard = Board(
            listOf(
                listOf(ALIVE, DEAD, ALIVE),
                listOf(DEAD, ALIVE, DEAD)

            )
        )
        assertEquals(soloBoard.countNeighbours(0, 1), 3)
        soloBoard.evolve()
        assertTrue(soloBoard.cellIsAlive(0, 1))
    }
}
