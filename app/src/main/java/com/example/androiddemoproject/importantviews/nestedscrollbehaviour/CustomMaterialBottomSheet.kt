package com.example.androiddemoproject.importantviews.nestedscrollbehaviour

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.FragmentCustomMaterialBottomSheetBinding
import com.example.androiddemoproject.importantviews.searchdebounce.PeopleAdapter
import com.example.androiddemoproject.importantviews.searchdebounce.Person
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CustomMaterialBottomSheet : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentCustomMaterialBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_custom_material_bottom_sheet,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvPeople.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = PeopleAdapter().also { adapter ->
                adapter.submitList((1..30).map {
                    Person(
                        "Person",
                        it.toString()
                    )
                })
            }
        }
    }
}