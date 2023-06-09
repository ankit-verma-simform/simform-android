package com.example.androiddemoproject.recyclerview.listadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemoproject.databinding.ActivityListAdapterBinding

class ListAdapterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListAdapterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Contacts"
        setupRecyclerView()
        setupReplaceContactListButton()
    }

    private fun setupReplaceContactListButton() {
        binding.btnReplaceNewList.setOnClickListener {
            val contacts = listOf(
                // no difference for first two contacts
                Contact(1, "Madhav", "+91 34895 90563"),
                Contact(2, "Vaibhav", "+91 89459 34785"),
                // numbers are modified
                Contact(3, "Mukesh", "+91 67845 86570"),
                Contact(4, "Ranveer", "+01 69058 90583"),
                // new contacts added
                Contact(5, "Denis", "+91 90034 59603"),
                Contact(6, "Ranveer", "+91 45890 45689"),
            )
            binding.rvContacts.adapter?.let {
                it as ContactListAdapter
                it.submitList(contacts)
            }
        }
    }

    private fun setupRecyclerView() {
        val contacts = listOf(
            Contact(1, "Madhav", "+91 34895 90563"),
            Contact(2, "Vaibhav", "+91 89459 34785"),
            Contact(3, "Mukesh", "+91 90564 86570"),
            Contact(4, "Ranveer", "+91 69058 90583"),
        )
        val adapter = ContactListAdapter()
        adapter.submitList(contacts)
        with(binding.rvContacts) {
            this.adapter = adapter
            addItemDecoration(ContactItemDecoration())
        }
    }
}