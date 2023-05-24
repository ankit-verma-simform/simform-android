package com.example.androiddemoproject.uiwidgets.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.onNavDestinationSelected
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val args: HomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val username = args.userName
        binding.textWelcome.text = getString(R.string.welcome_home_message, username)
        binding.btnAbout.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAboutFragment()
            findNavController().navigate(action)
        }
        binding.topAppBar.setOnMenuItemClickListener { item ->
            item.onNavDestinationSelected(navController = findNavController())
        }
        return binding.root
    }
}