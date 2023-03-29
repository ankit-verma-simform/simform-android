package com.example.androiddemoproject.revision.koans

/* Without collections higher order methods

fun doSomethingWithCollectionOldStyle(
    collection: Collection<String>
): Collection<String>? {
    val groupsByLength = mutableMapOf<Int, MutableList<String>>()
    for (s in collection) {
        var strings: MutableList<String>? = groupsByLength[s.length]
        if (strings == null) {
            strings = mutableListOf()
            groupsByLength[s.length] = strings
        }
        strings.add(s)
    }

    var maximumSizeOfGroup = 0
    for (group in groupsByLength.values) {
        if (group.size > maximumSizeOfGroup) {
            maximumSizeOfGroup = group.size
        }
    }

    for (group in groupsByLength.values) {
        if (group.size == maximumSizeOfGroup) {
            return group
        }
    }
    return null
}
 */

/* New Style */
fun doSomethingWithCollection(collection: Collection<String>): Collection<String>? {
    val groupsByLength = collection.groupBy { s -> s.length }
    val maximumSizeOfGroup = groupsByLength.values.maxOfOrNull { group -> group.size }
    return groupsByLength.values.firstOrNull { group -> group.size == maximumSizeOfGroup }
}