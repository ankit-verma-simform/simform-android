package com.example.androiddemoproject.kotlinbasics

fun main() {
    // Sets overview

    val mySet = setOf(1, 2, 3, 4, 5, 6, 7, 7, 8) // will store unique elements
    println(mySet)

    val emptySet = setOf<String>() // need to explicitly mention type; here String
    println(emptySet)

    val anotherEmptySet = emptySet<String>()
    println("Is anotherEmptySet empty? ${anotherEmptySet.isEmpty()}")

    // Set default implemented by LinkedHashSet; preserves insertion order
    println("First element, Last element of mySet: ${mySet.first()}, ${mySet.last()}")

    // order doesn't matter to compare 2 sets
    val anotherSet = mutableSetOf(8, 7, 1, 2, 3)
    anotherSet.add(4)
    anotherSet.addAll(listOf(5, 6))
    println("mySet == anotherSet? ${mySet == anotherSet}")

    // check if set contains particular element
    println("9 in mySet? ${9 in mySet}")
    println("7 in mySet? ${mySet.contains(7)}")

    val sortedSetValues = anotherSet.sorted() // can sort set to a list
    println("Sorted set values as list: $sortedSetValues")

    // Lists overview

    val myList = listOf(1, 2, 3, 4, 5, 6, 7, 7, 8) // can store duplicates + preserve order
    println(myList)

    val emptyList = listOf<String>()
    println(emptyList)

    val anotherEmptyList = emptyList<String>()
    println("Is myList empty? ${myList.isEmpty()}")

    // List default implemented by ArrayList; preserves insertion order
    println("First element, Last element of myList: ${myList.first()}, ${myList.last()}")
    println("Can access random element using index; myList[3] = ${myList[3]}")

//    val noSuchListElement = myList[300] // accessing out of range indexed value will throw runtime error
//    myList[0] = 6 // cannot set new value if list is not mutable; compile time error

    val anotherList = mutableListOf(4, 3, 2, 1, 5, 6, 7, 8, 7)
    // order matters for list comparison
    println("myList == anotherList? ${myList == anotherList}")

    // use sorted to get sorted list
    val sortedList = anotherList.sorted() // returns a new list
    println("Sorted list: $sortedList")
    println("Another list: $anotherList") // won't change the original list

    // use sort to sort the original list
    anotherList.sort()
    println("Another list: $anotherList") // changed the original list

    // check if myList contains particular element
    println("9 in myList? ${9 in myList}")
    println("7 in myList? ${myList.contains(7)}")

    // Maps overview
    val myMap = mapOf(
        1 to "ibm",
        1 to "google",
        5 to "amazon",
        6 to "microsoft"
    ) // can store key-value pairs where key must be unique, value can be duplicate
    println(myMap)

    val emptyMap = emptyMap<String, String>()
    val anotherEmptyMap = mapOf<Int, String>()

    // empty maps of different <key,value> types will be same
    println("emptyMap == anotherEmptyMap? ${emptyMap == anotherEmptyMap}")

    // use buildMap
    val anotherMap = buildMap {
        put(2, "apple")
        put(3, "netflix")
        put(4, "meta")
    }
//    anotherMap[8] = "ibm" // buildMap returns a Map, will throw compilation error

    // order is not preserved in case of maps, no first(), or last() methods exists!

    val mutableMap = anotherMap.toMutableMap() // will return a new mutable map
    mutableMap[9] = "ibm"
    mutableMap[10] = "tcs"

    mutableMap.putAll(myMap) // add elements from another map

    // copying function create a shallow copy
    data class RandomData(var value: Int)

    val randomDataList = List(10) { RandomData(value = it) } // creates a list
    val mutableRandomDataList =
        randomDataList.toMutableList() // creates a mutable list shallow copy

    println(mutableRandomDataList[0])
    mutableRandomDataList[0].value = 100 // modifying value from mutableRandomDataList
    println(randomDataList[0]) // change is reflected to randomDataList

    // Iterators

    // iterating over set
    val setItr = mySet.iterator()
    print("Set elements at current iteration: ")
    while (setItr.hasNext()) {
        print("${setItr.next()}, ")
    }

    // iterating over list
    val listItr = myList.iterator()
    print("\nList elements at current iteration: ")
    while (listItr.hasNext()) {
        print("${listItr.next()}, ")
    }

    // as iterator reached the end, it has no more element to traverse
    println("\nlist iterator has next element? ${listItr.hasNext()}")

    val mapItr = myMap.iterator()
    print("\nMap elements at current iteration: ")
    while (mapItr.hasNext()) {
        val (key, value) = mapItr.next()
        print("$key=$value, ")
    }

    // a more convenient way is by using for loop
    print("\nanotherMap: ")
    for ((k, v) in anotherMap) {
        print("$k=$v, ")
    }

    // can use add, remove, set, methods to mutate the list
    val mutableListIterator = mutableRandomDataList.listIterator()
    mutableListIterator.add(RandomData(value = 99))
    mutableListIterator.next()
    mutableListIterator.set(RandomData(value = 87))
    mutableListIterator.next()
    mutableListIterator.remove()
    println()
    println(mutableRandomDataList)

    // printing even numbers using progression from 9 to 1
    val nineToOne = 9 downTo 1 step 2
    print("\n9 to 1 odd nums: ")
    for (i in nineToOne) print("$i, ")
    // we can reverse iterate a progression
    print("\n1 to 9 odd nums: ")
    for (i in nineToOne.reversed()) print("$i, ")

    // sequences
    val numberSequence = sequenceOf("one", "two", "three", "four")
    val nineToOneSequence =
        nineToOne.asSequence() // convert iterables to sequences using asSequence
    val infiniteFivesGPSequence = generateSequence(1) { it * 5 }
    println()
    println(infiniteFivesGPSequence.take(10).toList())
    println("Summing up all in nineToOne sequence: ${nineToOneSequence.sum()}")

    // map or filter are stateless operations on sequence, computes independently each element
    val infiniteFivesGPPlus1Sequence = infiniteFivesGPSequence.map { it + 1 }
    println("Inf. 5^x+1: (x = Z+)", infiniteFivesGPPlus1Sequence.take(5).toList())

    // sequence processing demo

    // sequence compute lazily (map/filter); element by element
    val wordList = "The quick brown fox jumps over the lazy dog".split(" ")
    val lengthsList = wordList
        .filter { println("filter: $it"); it.length > 3 }
        .map { println("length: ${it.length}"); it.length }
        .take(4)

    print("Lengths of first 4 words longer than 3 chars: ")
    println(lengthsList)

    //convert the List to a Sequence
    val wordsSequence = wordList.asSequence()
    val lengthsSequence = wordsSequence
        .filter { println("filter: $it"); it.length > 3 }
        .map { println("length: ${it.length}"); it.length }
        .take(4)

    print("Lengths of first 4 words longer than 3 chars: ")
    // terminal operation: obtaining the result as a List
    println(lengthsSequence.toList())

    // deep clone using .copy with .map
    val newRandomDataList = mutableRandomDataList.map { it.copy() }
    println("Current value", newRandomDataList[0])
    newRandomDataList[0].value = 111
    println("Updated value:", newRandomDataList[0])
    println("Value not changed in original list", mutableRandomDataList[0])

    // common operations on collections
    val longString =
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
    val words = longString.split(" ")
    val wordsThatStartWithA = words.filter { it.lowercase().startsWith("a") }
    println("Words that start with `A or a`", wordsThatStartWithA)

    // average word length of longString
    val averageWordLength = words.sumOf { it.length } / words.count()
    println("Avg. word length: $averageWordLength")

    // max words starts with?
    val freqCountMap = mutableMapOf<Char, Int>()
    for (word in words) {
        val firstChar = word.first().lowercaseChar()
        freqCountMap[firstChar] = (freqCountMap[firstChar] ?: 0) + 1
    }
    val (char, count) = freqCountMap.maxBy { it.value }
    println("Maximum words starts with $char with count of $count")

    // map function
    val sumN = List(10) { it * (it + 1) / 2 }
    println(sumN)
    val squareOfSumN = sumN.mapNotNull { if (it % 3 == 0) null else it * it }
    println(squareOfSumN)

    // filter function
    val sumNLessThan20 = sumN.filter { it < 20 }
    println(sumNLessThan20)

    // zip function -> returns List<Pair<L1, L2>>
    val colors = listOf("red", "green", "yellow")
    val fruits = listOf("apple", "grapes", "mangoes")
    val fruitColors = fruits zip colors
    println(fruitColors[1])

    // associate function
    val fruitWithColorsMap = fruitColors.associate { it.first to it.second }
    println(fruitWithColorsMap)

    // flatten -> higher dims to lower dims
    var twoDList = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9),
    )
    val flattenedList = twoDList.flatten()
    println("2d list", twoDList)
    println("flattened list", flattenedList)

    val flattenedMap = twoDList.flatMap { it.take(2) }
    println("Flattened map", flattenedMap)

    // joinToStrings
    val formattedFruits = fruits.joinToString(
        separator = " : ",
        prefix = "{ ",
        postfix = " }",
        limit = 2,
        transform = { it.capitalize() }
    )
    println("Formatted fruits: $formattedFruits")

    // filter by predicate
    val numbersGreaterThan5 = flattenedList.filter { it > 5 }
    println("Numbers > 5:", numbersGreaterThan5)

    // filter only if it is instance of certain type
    val fizzBuzzList = List(20) { it + 1 }.map {
        if (it % 3 == 0 && it % 5 == 0) "FizzBuzz"
        else if (it % 3 == 0) "Fizz"
        else if (it % 5 == 0) "Buzz"
        else it
    }
    println(fizzBuzzList.toList())
    val onlyNotFizzBuzz = fizzBuzzList.filterIsInstance<Int>()
    println("Not the 'fizz' or 'buzz':", onlyNotFizzBuzz)

    // partition
    val (onlyNotFizzBuzzLessThan10, onlyNotFizzBuzzNotLessThan10) =
        onlyNotFizzBuzz.partition { it < 10 }
    println("<10 fizzbuzz: $onlyNotFizzBuzzLessThan10")
    println(">=10 fizzbuzz: $onlyNotFizzBuzzNotLessThan10")

    // test predicates
    println("Fruits: $fruits")

    println("Any fruit starts with 'g'?",
        fruits.any { it.first().lowercase() == "g" })

    println("All fruits are have length >4?",
        fruits.all { it.length > 4 })

    println("No fruit end with 'e'",
        fruits.none { it.endsWith("e") })

    println("Are there any fruit left? ${fruits.any()}")
    println("Are there no fruit left? ${fruits.none()}")

    println("Empty collection with all gives true regardless of predicate",
        emptyList<Int>().all { it === 0 }
    )

    // plus and minus operators on collections
    println("FizzBuzz List: $fizzBuzzList")
    val listWithoutFirstFizz = fizzBuzzList - "Fizz" // removes 1st occurrence
    println("List without first fizz: $listWithoutFirstFizz")

    val listWithoutFizzBuzz = fizzBuzzList - listOf("FizzBuzz") // removes all occurrences
    println("List without all FizzBuzz: $listWithoutFizzBuzz")

    val adding3ToFizzBuzz = fizzBuzzList + 3 // add 1 member
    println(
        "Last 5 elements of adding3ToFizzBuzz:",
        adding3ToFizzBuzz.takeLast(5)
    )

    val addingListOf1sToFizzBuzz = fizzBuzzList + listOf(1, 11, 111) // add list
    println(
        "Last 5 elements of addingListOf1sToFizzBuzz:",
        addingListOf1sToFizzBuzz.takeLast(5)
    )

    // grouping
    val groupedFizzBuzz = fizzBuzzList.groupingBy {
        when (it) {
            is Int -> "values"
            is String -> when (it) {
                "FizzBuzz" -> "multiple of 3 & 5"
                "Fizz" -> "multiple of 3"
                "Buzz" -> "multiple of 5"
                else -> "unknown"
            }
            else -> "unknown"
        }
    }.eachCount()
    println(groupedFizzBuzz)

    // Retrieving collection part

    // slice
    val cubes = List(30) { it * it * it }
    println("Cubes: 1 to 5 ${cubes.slice(1..5)}")
    println("Cubes: 7, 9, 11 ${cubes.slice(7..11 step 2)}")
    println("Cubes: 12, 19, 27 ${cubes.slice(setOf(12, 19, 27))}")
    println("Cubes of >=15 ${cubes.drop(15)}")
    println("Cubes less than value 9999: ${cubes.takeWhile { it < 9999 }}")

    // chunking
    println(
        "Chunking flattened list into 2d",
        flattenedList.chunked(3)
    )

    // windowed
    val squares = (1..10).map { it * it }
    println("Windowed: ", squares.windowed(size = 3, step = 2))
    println("Windowed with operation",
        squares.windowed(size = 3, step = 2) { it.sum() })

    val shuffledNums = squares.shuffled()
    println(shuffledNums)
    val keepMax = shuffledNums.zipWithNext { a, b -> a > b }
    println(keepMax)
    val maxValue = keepMax.last()
    println("Max value: $maxValue")

    // retrieve by position
    println("Element at 4th position in squares: ${squares.elementAt(4)}")
    println("Element at 99th position in squares:",
        squares.elementAtOrElse(99) { "No element at position $it" })

    // retrieve by condition
    println("First square > 50:", squares.first { it > 50 })

    // retrieve by selector
    val mixedList = listOf(3, true, false, null, null, "k", "hi", "zero", "3.14")
    val firstValueMoreThanLength4 = mixedList
        .firstNotNullOfOrNull { value ->
            value.toString()
                .takeIf { it.length > 4 }
        }
    println("First value >4 length:", firstValueMoreThanLength4)

    // get random
    println("Mixed list random: ${mixedList.random()}")

    // ordering

    // sorting
    data class Person(var firstName: String, val lastName: String) :
        Comparable<Person> {
        override fun compareTo(other: Person): Int =
            if (firstName != other.firstName)
                firstName.compareTo(other.firstName)
            else
                lastName.compareTo(other.lastName)
    }

    val people = listOf(
        Person("Jake", "Hill"),
        Person("Mike", "Hill"),
        Person("Adam", "Smith"),
        Person("Mike", "Lee"),
    )
    println("People sorted: ${people.sorted()}")

    val poepleByLastName = people.sortedWith(compareBy { it.lastName })
    println("Sorted people by lastname: $poepleByLastName")

    // reversed people - returns new list
    val reversedPeople = people.reversed()
    people.first().firstName = "Aman"
    println("Modified people: $people")
    println("Reversed people:", reversedPeople)

    // asReversed people - returns reversed view of same collection
    val asReversedPeople = people.asReversed()
    people.last().firstName = "Jack"
    println("asReversed people: $asReversedPeople")

    // aggregate functions
    val randomNumbers = (1..10)
        .map {
            kotlin.random.Random(it)
                .nextInt(from = 1, until = 100)
        }
    println("Random numbers: $randomNumbers")
    println("Sum: ${randomNumbers.sum()}")
    println("Max: ${randomNumbers.maxOrNull()}")
    println("Min: ${randomNumbers.minOrNull()}")
    println("Count: ${randomNumbers.count()}")
    println("Average: ${randomNumbers.average()}")

    // fold and reduce
    val sumTotalUsingReduce =
        randomNumbers.reduce { currentSum, value -> currentSum + value }
    val sumTotalUsingFold =
        randomNumbers.fold(0) { currentSum, value -> currentSum + value }
    println(sumTotalUsingReduce, sumTotalUsingFold, randomNumbers.sum())

    // write operation
    val primes = mutableListOf<Int>()
    primes.add(2)
    primes.addAll(listOf(3, 5, 7))
    primes += 11
    primes += setOf(13, 17, 19)
    println("Primes:", primes)

    primes.retainAll { it < 10 }
    println("Modified primes: $primes")

    // List specific operations
    val powersOf3 = generateSequence(3) { it * 3 }.take(10).toList()
    println(powersOf3)
    println(powersOf3.binarySearch(28)) // -3 -1
    println(powersOf3.binarySearch(27)) // 2

    val mutablepowers3 = powersOf3.toMutableList()
    mutablepowers3.add(177147)
    mutablepowers3.removeAt(1) // remove value at index
    mutablepowers3.reverse() // sort in place

    println("Modified power of 3", mutablepowers3)
    mutablepowers3.fill(0) // fill all values with value
    println("After filling all values: $mutablepowers3")

    // set specific operations

    val primeSet = setOf(2, 3, 5, 7, 11, 13, 17)
    val evens = (2..20 step 2).toSet()
    val odds = (1..20 step 2).toSet()

    val all = evens union odds
    println("All values: $all")

    val notPrimeSet = all subtract primeSet
    println("Not prime numbers: $notPrimeSet")

    val evenPrimes = evens intersect primeSet
    println("Even primes: $evenPrimes")

    // map specific operations

    val myDict = mutableMapOf(
        "apple" to "a fruit that keeps doctor away",
        "king" to "ruler of a region",
    )

    myDict["mango"] = "summer season fruit"
    myDict += setOf(
        Pair("google", "to search"),
        Pair("sun", "only star of the solar system")
    )
    myDict += Pair("Maths", "Language of Physics")
    myDict -= "grapes"
    myDict.remove("king")
    println("myDict:", myDict)

    // scope functions

    data class Product(var name: String, var price: Double = 0.0)

    val chocolatePizzaTax = Product(name = "Pizza", price = 300.0).run {
        name = "Chocolate Pizza"
        price = 99.99
        price * 0.33
    }
    // run method return last statement result! can access this

    val mangoJuiceTax = Product(name = "Mango Juice", price = 111.1).let {
        it.name = "Kesar Mango Juice"
        it.price * 0.2
    }
    // let method return last statement result! can access it

    val almonds = with(Product(name = "Almonds", price = 999.99)) {
        name = "Almonds x1 kg"
        price = 1345.0
        price * .34
    }
    // with returns last statement result! can access this

    val smartphone = Product(name = "Smartphone", price = 34_343.99).also {
        it.name = "Xiaomi Note 17"
        it.price = 28999.9
    }
    // also method returns the context object, can access it
    println("Smartphone: $smartphone")

    val book = Product(name = "Book", price = 343.99).apply {
        name = "Think & Grow Book"
        price = 99.99
    }
    // also method returns the context object, can access this
    println("Book: $book")
}
