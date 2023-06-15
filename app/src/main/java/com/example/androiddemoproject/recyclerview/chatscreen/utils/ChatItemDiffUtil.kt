package com.example.androiddemoproject.recyclerview.chatscreen.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.androiddemoproject.recyclerview.chatscreen.model.ChatItem

class ChatItemDiffUtil : DiffUtil.ItemCallback<ChatItem>() {
    override fun areItemsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
        return oldItem == newItem
    }
}
