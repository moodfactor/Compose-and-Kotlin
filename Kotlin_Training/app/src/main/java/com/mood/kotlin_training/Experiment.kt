package com.mood.kotlin_training

fun main() {
//    val listOfNames = listOf<String>("Ahmed", "Moayad", "Aya")
//    val listOfNumbers = listOf<Int>(1, 2, 3)
////    val getItInvoke = listOfNames.getFirstElement{list -> list[1] }
//    val operation = listOfNumbers.getAnyElement()
//    println(operation)
//    val listOfNumber = listOf(1, 5, 87, 45, 8, 8)
//    println(twoOldestAges(listOfNumber))
    val words = "This is another test"
//    val word = "Another"
//    println(word.reversed())
//    println(words.split("\\s+".toRegex(),0).filter { s -> s.length > 5 }.last().reversed())
//    println(words.split(" ").apply {
//        var ss = StringBuilder()
//        for (s in this){
//            if (s.length > 5){
//              ss.append(s)
//            }
//            return@apply
//        }
//    }.toString())
//    println(words.split(" ").filter { s -> s.length >5 }.last().reversed())
//    println(words.replace(words,transform= () ))
    println(words.split(" ").toMutableList().toString())
    println(spinWords(words))
}

//public String spinWords(String sentence) {
//    String[] arr = sentence.split(" ");
//    for(int i=0;i<arr.length;i++){
//        if(arr[i].length() >= 5)
//            arr[i] = new StringBuffer(arr[i]).reverse().toString();
//    }
//    return String.join(" ",arr);
//}
//}

fun spinWords(sentence: String): String{
    var separate = sentence.split(" ").toMutableList()
    for (n in separate){
        if (n.length >5){
            val rev = n.reversed().toString()
            separate.add(rev)
            break
        }else{
            separate.add(n)
            break
        }
    }
    return separate.toList().toString()

}


//fun spinWords(sentence: String): String {
//    var backword = "";
//    var separate = sentence.split(" ");
//
//    for (n in separate) {
//        if (n.length >= 5) {
//            backword += n.split(" ").reversed().joinToString(",")
//        } else {
//            backword += n
//        }
//    }
//    return backword
//}
//    val final = ""
//    val seperate = sentence.split("\\s+")
//    val stringBuilder = StringBuilder()
//   for (s in seperate){
//       when(s.length){
//           2 -> stringBuilder.append(s)
//           7 -> s.reversed().also { stringBuilder.append(s) }
//           else -> println("error")
//       }
//       return stringBuilder.toString()
//   }
//    return stringBuilder.toString()


//fun spinWords(sentence: String): String {
//    val final = ""
//    val separate = sentence.split("\\s+")
//    var stringBuilder = StringBuilder()
//    for (n in separate){
//        if (n.length <5) {
//            stringBuilder.append(n)
//        }else if (n.length > 5){
//            val ss = n.reversed()
//            stringBuilder.append(ss)
//        }
//    }
//    return stringBuilder.toString()
//}

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
