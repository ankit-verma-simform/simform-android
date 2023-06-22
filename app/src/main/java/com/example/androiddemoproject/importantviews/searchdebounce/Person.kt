package com.example.androiddemoproject.importantviews.searchdebounce

data class Person(
    val firstName: String,
    val lastName: String
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$firstName$lastName",
            "$firstName $lastName",
            "${firstName.first()} ${lastName.first()}",
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}

fun getAllPeople() = listOf(
    Person(firstName = "Ankit", lastName = "Verma"),
    Person(firstName = "Vaibhav", lastName = "Gupta"),
    Person(firstName = "Madhav", lastName = "Kalariya"),
    Person(firstName = "Ranveer", lastName = "Solanki"),
    Person(firstName = "Dharmik", lastName = "Upadhyaya"),
)