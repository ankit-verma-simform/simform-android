package com.example.androiddemoproject.uiwidgets.screens.guestsecurecheckoutscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityGuestSecureCheckoutBinding
import com.google.gson.Gson

class GuestSecureCheckoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGuestSecureCheckoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestSecureCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupSpinners()
        setupDateTimePickers()
        setupNextButton()
    }

    private fun setupNextButton() {
        binding.reservationDetails.btnNext.setOnClickListener {
            startParkingReceiptActivity()
        }
    }

    private fun startParkingReceiptActivity() {
        val guestReservationDetails = getGuestReservationDetails()
        val guestReservationDetailsJson = Gson().toJson(guestReservationDetails)
        val intent = Intent(this, ParkingReceiptActivity::class.java)
        intent.putExtra("guestReservationDetails", guestReservationDetailsJson)
        startActivity(intent)
        finish()
    }

    private fun getGuestReservationDetails(): GuestReservationDetails {
        val countriesWithStatesMap = GuestSecureCheckoutConstants.getCountriesWithStates()
        val countries = countriesWithStatesMap.keys.toList()
        val country = countries[binding.reservationDetails.spinnerCountry.selectedItemPosition]
        return with(binding.reservationDetails) {
            GuestReservationDetails(
                email = "adam21_newton@gmail.com",
                enterAfterDate = tvDateEnterAfter.text.toString(),
                enterAfterTime = tvTimeEnterAfter.text.toString(),
                exitBeforeDate = tvDateExitBefore.text.toString(),
                exitBeforeTime = tvTimeExitBefore.text.toString(),
                vehicleMakeAndModel = editVehicleMakeAndModel.text.toString(),
                vehicleType = editLicensePlateNumber.text.toString(),
                isOversizeVehicle = chechboxIsOversizedVehicle.isChecked,
                country = country,
                state = countriesWithStatesMap[country]?.get(spinnerState.selectedItemPosition)
                    ?: "",
                licenseNumber = editLicensePlateNumber.text.toString()
            )
        }
    }

    private fun setupSpinners() {
        val countriesWithStates = GuestSecureCheckoutConstants.getCountriesWithStates()
        val countries = countriesWithStates.keys.toList()
        binding.reservationDetails.spinnerCountry.addAdapter(this, countries)

        binding.reservationDetails.spinnerCountry.onItemSelectedListener =
            object : OnItemSelectedListener {
                override fun onItemSelected(
                    adapter: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    long: Long
                ) {
                    binding.reservationDetails.spinnerState.addAdapter(
                        this@GuestSecureCheckoutActivity,
                        countriesWithStates[countries[position]].orEmpty()
                    )
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }

        binding.reservationDetails.spinnerTypeOfOversizedVehicle.addAdapter(
            this,
            GuestSecureCheckoutConstants.getTypeOfOversizeVehicles()
        )
    }

    private fun <T> Spinner.addAdapter(
        context: Context,
        itemList: List<T>,
        @LayoutRes spinnerItem: Int = R.layout.guest_secure_checkout_custom_spinner_item,
        @LayoutRes dropDownViewResource: Int = android.R.layout.simple_spinner_dropdown_item
    ) {
        val adapter = ArrayAdapter(
            context,
            spinnerItem,
            itemList
        )
        adapter.setDropDownViewResource(dropDownViewResource)
        this.adapter = adapter
    }

    private fun setupDateTimePickers() {
        binding.reservationDetails.btnEditEnterAfter.setupDateTimePickerOnClickListener(
            this,
        ) { date, time ->
            binding.reservationDetails.tvDateEnterAfter.text = date
            binding.reservationDetails.tvTimeEnterAfter.text = time
        }
        binding.reservationDetails.btnEditExitBefore.setupDateTimePickerOnClickListener(
            this
        ) { date, time ->
            binding.reservationDetails.tvDateExitBefore.text = date
            binding.reservationDetails.tvTimeExitBefore.text = time
        }
    }
}
