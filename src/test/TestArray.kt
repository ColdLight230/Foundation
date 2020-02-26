package test


fun main(args: Array<String>) {
    var index = 0
//    val array = Array(3) { Array(3) { index++ } }
//    for (ints in array) {
//        for (int in ints) {
//            println(int.toString())
//        }
//    }
    val array = mutableListOf(1, 2, 3, 4, 5, 6)
    array.subList(4, array.size).clear()
    for (i in array) {
        print("$i->")
    }
}
