package com.example.androiddemoproject.uiwidgets.screens.guestsecurecheckoutscreen

import java.io.Serializable

data class GuestReservationDetails(
    val email: String,
    val enterAfterDate: String,
    val enterAfterTime: String,
    val exitBeforeDate: String,
    val exitBeforeTime: String,
    val vehicleMakeAndModel: String,
    val licenseNumber: String,
    val country: String,
    val state: String,
    val isOversizeVehicle: Boolean,
    val vehicleType: String
): Serializable
