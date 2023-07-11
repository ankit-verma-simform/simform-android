//package com.example.androiddemoproject.webservices.authretrofitrequests.adapter
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.databinding.DataBindingUtil
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.androiddemoproject.R
//import com.example.androiddemoproject.databinding.PassengerListItemBinding
//import com.example.androiddemoproject.webservices.authretrofitrequests.model.TouristPassenger
//
//class TouristPassengersAdapter :
//    ListAdapter<TouristPassenger, TouristPassengersAdapter.ViewHolder>(TouristPassengerDiffUtil()) {
//    inner class ViewHolder(val binding: PassengerListItemBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(passenger: TouristPassenger) {
//            binding.passenger = passenger
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val binding = DataBindingUtil.inflate<PassengerListItemBinding>(
//            LayoutInflater.from(parent.context),
//            R.layout.passenger_list_item,
//            parent, false
//        )
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(getItem(position))
//    }
//
//    class TouristPassengerDiffUtil : DiffUtil.ItemCallback<TouristPassenger>() {
//        override fun areItemsTheSame(
//            oldItem: TouristPassenger,
//            newItem: TouristPassenger
//        ): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(
//            oldItem: TouristPassenger,
//            newItem: TouristPassenger
//        ): Boolean {
//            return oldItem == newItem
//        }
//    }
//}