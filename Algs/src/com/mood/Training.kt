package com.mood

fun main() {
//    val items = mutableListOf(1, 2, 56, 4, 5, 8, 3)
//    val result = items.fold(1) { acc: Int, i: Int -> acc + i }
//    println("Ahmed".repeatIt(5))
//    println(repeatIt("Ahmed", 5))
//    println(repeatMe { word, times -> "word".repeat(5) })
//    println(repeatMe(repeatIt))
//    val a = "Ahmed"
//    val m = "Mohamed"
//    val redu = items.reduce { acc, next -> acc - next }
//    typeName { println({ 3 + 3 }) }
//    val entity = Entity("Ahmed", Country.Egypt)
//    val listOfResidents = listOf<Entity>(
//        entity,
//        Entity("John", Country.UnitesState),
//        Entity("Mohame", Country.Egypt),
//        Entity("Omar", Country.Lybia)
//    )
//    val listOfCountries = listOf<Country>(Country.Egypt, Country.UnitesState, Country.Lybia)
//    val numberOfEgyptians = listOfResidents.map { listOfResidents -> listOfResidents.isFrom }
//        .count { Country -> Country == com.mood.Country.Egypt }
//    val num = listOfResidents.count { it.isFrom == Country.Egypt }
//    val egyCount = listOfResidents.asSequence().map { it.name }.filter { s -> s == "Ahmed" }.toList()
//    val upper = entity.name.uppercase()
//    val comp = listOfResidents.asSequence().map { it.name }.sortedBy { it.length }.toList()
//    val reduce = items.asSequence().reduce { acc, i -> acc * i }.toString()
//    val flatMap = listOfResidents.asSequence().flatMap { it -> it.name.asSequence() }.toList()
//    println("Egyptians: $flatMap")
//    val calculator = getShippingCost(Delivery.Excepited)
//    println(calculator(Order(3)))
//
//    val averageWin = log.averageDurationPredicate { it.os == OS.LINUX }
//    println("average: $averageWin")
//    lessonsDist( 60)

    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    people.lookForAlice {  }
}

data class Person(val name: String, val age: Int)


inline fun List<Person>.lookForAlice(operation: (List<Person>) -> Unit){
    this.forEach { person ->
        if (person.name == "Alice") {
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}
fun lessonsDist(num : Int): Int{
    var count = 0
    for (i in 1 until num step 5){
        println("lessons from $i to ${i+4} ")
        count++
    }
    println("Num of Weeks= $count")
    return count
}

fun List<SiteVisit>.averageDuration(os: OS) = filter { it.os == os }.map ( SiteVisit::duration ).average()
fun List<SiteVisit>.averageDurationByList(os: OS) = filter { it.os in setOf<OS>(OS.IOS, OS.ANDROID) }.map ( SiteVisit::duration ).average()
inline fun List<SiteVisit>.averageDurationPredicate(predicate: (SiteVisit) -> Boolean) = filter ( predicate ).map ( SiteVisit::duration ).average()


data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

val log = listOf(
    SiteVisit("/", 34.0, OS.WINDOWS),
    SiteVisit("/", 22.0, OS.MAC),
    SiteVisit("/login", 12.0, OS.WINDOWS),
    SiteVisit("/signup", 8.0, OS.IOS),
    SiteVisit("/", 16.3, OS.ANDROID)
)

enum class Delivery{ Standard, Excepited}

class Order(val itemCount: Int)

fun getShippingCost(delivery: Delivery): (Order) -> Double{
    if (delivery == Delivery.Excepited){
        return {order -> 6 + 2.1 * order.itemCount }
    }

    return {order -> 1.2  * order.itemCount }
}

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()){
        if (index > 0 ) result.append(separator)
        val str = transform?.invoke(element)
            ?: element.toString()
        result.append(str)
    }
    result.append(postfix)
    return result.toString()
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

class Entity(val name: String, val isFrom: Country)
enum class Country {
    UnitesState,
    Egypt,
    Lybia
}

fun typeName(name: () -> Unit): Unit = name()

//inline fun MutableList<Int>.filterMe(operation: (Int) -> Boolean): List<Int> {
//    for(n in this){
//        if (operation(n)) {this.add(n)}
//        else {return emptyList()}
//    }
//    return this
//}
val repeatIt: String.(Int) -> String = { times -> this.repeat(times) }
fun repeatMe(repeatT: (word: String, times: Int) -> String): String = repeatT("ahmd", 3)