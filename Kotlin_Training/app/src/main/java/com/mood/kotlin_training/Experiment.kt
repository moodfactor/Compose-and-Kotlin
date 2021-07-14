package com.mood.kotlin_training

fun main() {
    val listOfNames = listOf<String>("Ahmed", "Moayad", "Aya")
    val listOfNumbers = listOf<Int>(1, 2, 3)
//    val getItInvoke = listOfNames.getFirstElement{list -> list[1] }
    val operation = listOfNumbers.getAnyElement()
    println(operation)
    val listOfNumber = listOf(1, 5, 87, 45, 8, 8)
    println(twoOldestAges(listOfNumber))
}

fun twoOldestAges(ages: List<Int>): List<Int> {
    return ages.sortedDescending().take(2).sorted()
}

// return index of any type of lists just like get collection function
fun <T> List<T>.getAnyElement(getIt: (List<T>) -> T = { it[1] }): T {
    return getIt(this)
}

fun addTwoNumbers(add: (a: Int, b: Int) -> Int): Int {
    return addTwoNumbers { a, b -> a + b }
}

enum class Delivery { STANDARD, EXPEDITED }
class Order(val itemCount: Int)

fun getShippingCostCalculator
            (delivery: Delivery): (Order) -> Double {
    if (delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return { order -> 1.2 * order.itemCount }
}
