package com.example.androiddemoproject.uiwidgets.screens.guestsecurecheckoutscreen

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityParkingReceiptBinding
import com.google.gson.Gson

class ParkingReceiptActivity : AppCompatActivity() {
    private lateinit var binding: ActivityParkingReceiptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParkingReceiptBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupDateTimePickerOnClickListener()
        setupMenu()
        setupUIData()
        setAddressesToDisplayInMarqueeStyle()
        setupParkingReceiptDisplayCardButton()
    }

    private fun setupParkingReceiptDisplayCardButton() {
        val spannableText = SpannableString(getString(R.string.access_button_message))
        val startIndex = spannableText.indexOf("My Account")
        val endIndex = spannableText.length
        val clickAbleSpan = object : ClickableSpan() {
            override fun updateDrawState(textPaint: TextPaint) {
                textPaint.color = Color.argb(255, 7, 117, 121)
                textPaint.isUnderlineText = false
            }

            override fun onClick(view: View) {
                Toast.makeText(
                    this@ParkingReceiptActivity,
                    "Going to my Account",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        spannableText.setSpan(clickAbleSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.displayPassCard.description.text = spannableText
        binding.displayPassCard.description.movementMethod = LinkMovementMethod.getInstance()
        binding.displayPassCard.description.highlightColor = Color.TRANSPARENT
    }

    private fun setupUIData() {
        val guestReservationDetails = intent.getStringExtra("guestReservationDetails")?.let {
            Gson().fromJson(it, GuestReservationDetails::class.java)
        }
        guestReservationDetails?.let {
            fillUpData(it)
        }
    }

    private fun setAddressesToDisplayInMarqueeStyle() {
        binding.cardParkingPass.tvAddress1.isSelected = true
        binding.cardParkingPass.tvAddress2.isSelected = true
    }

    private fun fillUpData(guestReservationDetails: GuestReservationDetails) {
        binding.cardParkingPass.run {
            tvAddress1.text = guestReservationDetails.state.repeat(30)
            tvAddress2.text = guestReservationDetails.country.repeat(30)
            tvVehicleAndMake.text = guestReservationDetails.vehicleMakeAndModel
            tvEnterAfterDateTime.text = getString(
                R.string.formatted_date_time,
                guestReservationDetails.enterAfterDate,
                guestReservationDetails.enterAfterTime
            )
            tvExitBeforeDateTime.text = getString(
                R.string.formatted_date_time,
                guestReservationDetails.exitBeforeDate,
                guestReservationDetails.exitBeforeTime
            )
        }
        binding.tvEmailSendInfo.text =
            getString(R.string.email_send_info, guestReservationDetails.email)
    }

    private fun setupDateTimePickerOnClickListener() {
        binding.cardParkingPass
            .btnEditEnterAfter
            .setupDateTimePickerOnClickListener(
                this
            ) { date, time ->
                binding.cardParkingPass
                    .tvEnterAfterDateTime.text = getString(R.string.formatted_date_time, date, time)
            }

        binding.cardParkingPass
            .btnEditExitBefore
            .setupDateTimePickerOnClickListener(
                this
            ) { date, time ->
                binding.cardParkingPass.tvExitBeforeDateTime.text =
                    getString(R.string.formatted_date_time, date, time)
            }
    }

    private fun setupMenu() {
        binding.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.close -> {
                    finish()
                    true
                }
                else -> false
            }
        }
    }
}