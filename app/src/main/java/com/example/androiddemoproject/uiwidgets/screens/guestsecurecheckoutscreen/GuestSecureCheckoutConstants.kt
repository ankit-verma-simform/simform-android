package com.example.androiddemoproject.uiwidgets.screens.guestsecurecheckoutscreen

object GuestSecureCheckoutConstants {
    fun getCountriesWithStates(): Map<String, List<String>> {
        return mapOf(
            "Australia" to listOf(
                "New Wales",
                "Queensland",
                "Southern",
                "Tasmania",
                "Victoria",
                "Western",
            ),
            "Canada" to listOf(
                "Alberta",
                "British Columbia",
                "Manitoba",
                "Newfoundland and Labrador",
                "New Brunswick",
                "Northwest Territories",
            ),
            "India" to listOf(
                "Delhi",
                "Gujarat",
                "Haryana",
                "Karnataka",
                "Maharashtra",
                "MP",
            ),
            "US" to listOf(
                "Alaska",
                "Arizona",
                "New York",
            ),
        )
    }

    fun getTypeOfOversizeVehicles(): List<String> {
        return listOf(
            "Buses & SUVs",
            "Campers",
            "Large & Heavy Trucks",
            "Pull Behind",
            "Trailers",
        )
    }
}