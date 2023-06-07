package com.example.androiddemoproject.uiwidgets.screens.guestsecurecheckoutscreen

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityGuestSecureCheckoutBinding
import com.google.android.material.datepicker.MaterialDatePicker

class GuestSecureCheckoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGuestSecureCheckoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestSecureCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupSpinners()
        setupDatePickers()
    }

    private fun setupSpinners() {
        val countriesWithStates = GuestSecureCheckoutConstants.getCountriesWithStates()
        val countries = countriesWithStates.keys.toList()

        binding.reservationDetails.spinnerCountry.addAdapter(
            this,
            countries
        )

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
            GuestSecureCheckoutConstants.getTypeOfOversizedVehicles()
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

    private fun setupDatePickers() {
        binding.reservationDetails.btnEditEnterAfter.setupDatePickerOnClickListener(
            textViewToShowDate = binding.reservationDetails.tvDateEnterAfter
        )
        binding.reservationDetails.btnEditExitBefore.setupDatePickerOnClickListener(
            textViewToShowDate = binding.reservationDetails.tvDateExitBefore
        )
    }

    private fun View.setupDatePickerOnClickListener(textViewToShowDate: TextView) {
        setOnClickListener {
            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select date")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build()
            datePicker.show(supportFragmentManager, "datePicker")
            datePicker.addOnPositiveButtonClickListener {
                textViewToShowDate.text = datePicker.headerText
            }
        }
    }
}
