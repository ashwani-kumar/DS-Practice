fun main() {
    var fruits = arrayOfNulls<Person>(size=100000)
    for (i in fruits.indices) {
        fruits[i] = Person(100+i, "Person $i")
    }
    var result = fruits.map {
        it?.id to it?.name
    }.toMap()
    print(result)
}

data class Person(val id: Int, val name: String)