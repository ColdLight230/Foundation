package test


/**
 * 删除字符串中的空格
 */
fun main(args: Array<String>) {
    println(deleteBlankSpace(" I lo ve  y ou"))
    println(" I lo ve  y ou  ")

}

fun deleteBlankSpace(string: String): String {
    val charArray = string.toCharArray()
    var i = 0
    var j = 0
    while (charArray[i] == ' ') {
        i++
    }
    while (i < charArray.size) {
        if (charArray[i] == ' ' ) {
            i++
            continue
        }
        charArray[j++] = charArray[i++]
    }
    return charArray.take(j).toString()
}
