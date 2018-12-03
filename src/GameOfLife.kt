class Cell(val x: Int, val y: Int, val alive: Boolean)


class Board(val cells: Array<Array<Cell>>) {
    fun cellIsAlive(x: Int, y: Int): Boolean = cells.getOrNull(x)?.getOrNull(y)?.alive ?: false
}