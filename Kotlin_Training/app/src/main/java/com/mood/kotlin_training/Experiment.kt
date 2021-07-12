package com.mood.kotlin_training

fun main(){
    val listOfNames = listOf<String>("Ahmed", "Moayad", "Aya")
    val getItInvoke = listOfNames.getFirstElement {l -> l[1]  }
    println(getItInvoke)
}

fun List<String>.getFirstElement(getIt: (List<String>) -> String): String{
    return getIt(this)
}