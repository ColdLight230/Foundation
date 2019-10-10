package test

fun main(args: Array<String>) {
    val changed = false

    println(" isChanged: " + (changed xor false xor false))
    println(" isChanged: " + (changed xor true xor false))
    println(" isChanged: " + (changed xor false xor true))
    println(" isChanged: " + (changed xor true xor true))
}
