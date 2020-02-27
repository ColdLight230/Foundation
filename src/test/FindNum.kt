package test

/**
 * 整数数组中找出前边的数都比自己小，后边的数都比自己大的数
 */
fun main(args: Array<String>) {
    val array = arrayOf(1, 2, 4, 5, 3, 6)
    println("result -> ${findNumInArray(array)}")

}

/**
 * 通过两次遍历
 * 第一次把前面数比自己小的数找出来
 * 第二次把后面数比自己小的数删除掉
 */
fun findNumInArray(n: Array<Int>): ArrayList<Int> {
    val result = arrayListOf<Int>()
    var max = Int.MIN_VALUE
    for (withIndex in n.withIndex()) {
        if (withIndex.value > max) {
            result.add(withIndex.value)
            max = withIndex.value
        }
    }
    var min = Int.MAX_VALUE
    for (i in n.reversed()) {
        if (i > min && result.contains(i)) {
            result.remove(i)
        } else {
            min = i
        }
    }
    return result
}
