package com.example.androiddemoproject.importantviews.nestedscrollbehaviour

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityNestedScrollBehaviourBinding
import com.example.androiddemoproject.databinding.BottomSheetBinding
import com.example.androiddemoproject.importantviews.searchdebounce.PeopleAdapter
import com.example.androiddemoproject.importantviews.searchdebounce.Person
import com.google.android.material.bottomsheet.BottomSheetDialog

class NestedScrollBehaviourActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNestedScrollBehaviourBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nested_scroll_behaviour)
        binding.btnShowBottomSheet.setOnClickListener {
            showBottomSheet()
        }
        binding.btnShowMaterialBottomSheet.setOnClickListener {
            showMaterialBottomSheet()
        }
    }

    private fun showMaterialBottomSheet() {
        CustomMaterialBottomSheet().show(supportFragmentManager, "customSheet")
    }

    private fun showBottomSheet() {
        val dialogBinding = DataBindingUtil.inflate<BottomSheetBinding>(
            layoutInflater,
            R.layout.bottom_sheet,
            null,
            false
        )
        val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
        dialog.setContentView(dialogBinding.root)
        dialogBinding.rvPeople.apply {
            layoutManager = LinearLayoutManager(this@NestedScrollBehaviourActivity)
            adapter = PeopleAdapter().also { adapter ->
                adapter.submitList((1..30).map {
                    Person(
                        "Person",
                        it.toString()
                    )
                })
            }
            ViewCompat.setNestedScrollingEnabled(this, false)
        }
        dialog.show()
    }
}