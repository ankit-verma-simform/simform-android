package com.example.androiddemoproject.kotlinbasics

import java.util.Comparator

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
    val longString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
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

}
