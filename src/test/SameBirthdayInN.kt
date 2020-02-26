package test

/**
 * 计算N个人中至少两人生日相同的概率
 */
fun main(args: Array<String>) {
    println("1 -> ${sameBirthday(1)}")
    println("2 -> ${sameBirthday(2)}")
    println("12-> ${sameBirthday(12)}")
    println("50 -> ${sameBirthday(50)}")
    println("365 -> ${sameBirthday(365)}")

}

fun sameBirthday(n: Int): Float {
    var result = 1f
    for (i in 0 until n) {
        result = result * (365 - i) / 365
    }
    return 1 - result
}
