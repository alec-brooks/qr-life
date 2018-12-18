class Cell(val x: Int, val y: Int, val alive: Boolean)


class Board(seed: List<List<Boolean>>) {
    private var cells: List<List<Cell>> = seed.mapIndexed { x, row ->
        row.mapIndexed { y, alive -> Cell(x, y, alive) }
    }

    fun cellIsAlive(x: Int, y: Int): Boolean = cells.getOrNull(x)?.getOrNull(y)?.alive ?: false

    fun countNeighbours(x: Int, y: Int): Int {
        return listOf(
            cellIsAlive(x, y + 1),
            cellIsAlive(x, y - 1),
            cellIsAlive(x + 1, y),
            cellIsAlive(x + 1, y + 1),
            cellIsAlive(x + 1, y - 1),
            cellIsAlive(x - 1, y),
            cellIsAlive(x - 1, y + 1),
            cellIsAlive(x - 1, y - 1)
        ).sumBy { if (it) 1 else 0 }
    }

    fun evolve(){
        cells = cells.mapIndexed { x, row ->
            row.mapIndexed { y, cell ->
                if (countNeighbours(cell.x, cell.y) < 2 || countNeighbours(cell.x, cell.y) > 3)
                    Cell(x, y, false)
                else if (countNeighbours(cell.x, cell.y) == 3){
                    Cell(x, y, true)
                }
                else
                    cell
            }
        }
    }
}