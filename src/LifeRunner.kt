import kotlin.random.Random

fun main(args : Array<String>) {
    val iterations = (args.getOrNull(0) ?: "50").toInt()
    val board = Board(List(20) { List(20) { Random.nextBoolean() } })
    print(board.toString())
    (0..iterations).forEach {_ ->
        print("\n====================\n")
        board.evolve()
        print(board.toString())
    }
}
