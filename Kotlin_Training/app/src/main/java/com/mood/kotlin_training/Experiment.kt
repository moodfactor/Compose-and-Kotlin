package com.mood.kotlin_training

fun main(){
    val listOfNames = listOf<String>("Ahmed", "Moayad", "Aya")
    val listOfNumbers = listOf<Int>(1, 2, 3)
//    val getItInvoke = listOfNames.getFirstElement{list -> list[1] }
    val operation = listOfNumbers.getAnyElement { i -> i[1] }
    println(operation)
}

// return index of any type of lists just like get collection function
fun <T> List<T>.getAnyElement(getIt: (List<T>) -> T): T {
    return getIt(this)
//    return getFirstElement { l -> l[1] }
}

fun addTwoNumbers(add: (a: Int,b: Int) -> Int): Int{
    return addTwoNumbers { a, b -> a+b }
}