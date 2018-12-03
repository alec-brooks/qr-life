import org.junit.jupiter.api.Test as test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GameOfLifeTest {
    @test fun canCheckAlive() {
        val board = Board(arrayOf(arrayOf(Cell(0, 0, true))))
        assertTrue { board.cellIsAlive(0,0) }
    }
    @test fun notDefinedIsDead() {
        val board = Board(arrayOf(arrayOf(Cell(0, 0, true))))
        assertFalse { board.cellIsAlive(1,1) }
    }
}
