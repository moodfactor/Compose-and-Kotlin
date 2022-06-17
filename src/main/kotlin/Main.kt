import kotlinx.html.stream.createHTML
import kotlinx.html.table
import kotlinx.html.td
import kotlinx.html.tr
import java.io.BufferedReader
import java.io.StringReader
import java.util.*

fun main(args: Array<String>) {
    printAllCaps("Ahmed")

    println(strLenSafe())

    val p1 = Person1("Ahmed", 35)
    val p2 = Person1("Ahmed", 20)

    println(p1 == p2)

    val myName = "null"
    println(myName.let { printHashCode(it) })

    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    addValidNumbers(numbers)

    val letters = Array<String>(26) { i -> ('a' + i).toString() }
    println(letters.joinToString(""))
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    lookForAlice(people)
    println(createSimpleTable())
    val s = buildString { it.append("Hello, ")
    it.append("World!")}

    println(s)
}

fun buildString(buildAction: (StringBuilder) -> StringBuilder) : String {
    return buildAction(StringBuilder()).toString()

}

fun createSimpleTable() = createHTML().table {
    tr {
        td { +"cell" }
    }
}

fun lookForAlice(people: List<Person>) {
    people.forEach(fun(person: Person) {
        if (person.firstName == "Alice") return
        println("${person.firstName} is not Alice")
    })
}

fun lookForAlice2(people: List<Person>) {
    people.forEach position@{
        if (it.firstName == "Alice") return@position
    }
    println("Alice might be somewhere")
}

fun lookForAlice1(people: List<Person>) {
    val d = people.firstOrNull { it.firstName == "A" }
    println(d)
}


fun addValidNumbers(numbers: List<Int?>) {
    var validNumbers = 0
    var inValidNumbers = 0
    for (n in numbers) {
        if (n != null) validNumbers += n
        else inValidNumbers++
    }
    println("number of valid Numbers : $validNumbers")
    println("number of invalid numbers: $inValidNumbers")
}

fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = kotlin.collections.ArrayList<Int?>()

    for (line in reader.lineSequence()) {

        val number = line.toIntOrNull()
        result.add(number)
    }

    return result
}

data class Person1(
    val name: String, val age: Int? = null
)


fun <T : Any> printHashCode(t: T): Int {
    return t.hashCode()
}

class Person(val firstName: String, val lastName: Int) {
    override fun equals(o: Any?): Boolean {
        val otherPerson = o as? Person ?: return false

        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int {
        return firstName.hashCode() * 37 + lastName.hashCode()
    }
}


fun strLenSafe(s: String? = ""): Int = s?.length ?: 0

fun printAllCaps(s: String?) {
    val allCaps: String? = s?.uppercase(Locale.getDefault())
    println(allCaps)
}



