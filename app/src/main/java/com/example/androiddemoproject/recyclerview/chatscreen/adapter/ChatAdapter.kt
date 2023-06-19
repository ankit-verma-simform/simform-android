package com.example.androiddemoproject.recyclerview.chatscreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ChatUserMessageBinding
import com.example.androiddemoproject.databinding.ChatsDateItemBinding
import com.example.androiddemoproject.databinding.CurrentUserMessageBinding
import com.example.androiddemoproject.recyclerview.chatscreen.model.ChatItem
import com.example.androiddemoproject.recyclerview.chatscreen.model.ChatMessage
import com.example.androiddemoproject.recyclerview.chatscreen.model.ChatsDate
import com.example.androiddemoproject.recyclerview.chatscreen.model.UserType
import com.example.androiddemoproject.recyclerview.chatscreen.utils.ChatItemDiffUtil
import com.example.androiddemoproject.recyclerview.chatscreen.viewholder.ChatViewHolder

class ChatAdapter : ListAdapter<ChatItem, ChatViewHolder>(ChatItemDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        when (viewType) {
            R.layout.chat_user_message -> {
                val binding = ChatUserMessageBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                return ChatViewHolder.ChatUserChatViewHolder(binding)
            }

            R.layout.current_user_message -> {
                val binding = CurrentUserMessageBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                return ChatViewHolder.CurrentUserChatViewHolder(binding)
            }

            R.layout.chats_date_item -> {
                val binding = ChatsDateItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                return ChatViewHolder.ChatsDateViewHolder(binding)
            }

            else -> throw IllegalArgumentException("No such user found!")
        }
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chatItem = getItem(position)

        when (holder) {
            is ChatViewHolder.ChatUserChatViewHolder -> holder.bind(chatItem as ChatMessage)
            is ChatViewHolder.CurrentUserChatViewHolder -> holder.bind(chatItem as ChatMessage)
            is ChatViewHolder.ChatsDateViewHolder -> holder.bind(chatItem as ChatsDate)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val chatItem = getItem(position)
        return when (chatItem) {
            is ChatsDate -> {
                return R.layout.chats_date_item
            }

            is ChatMessage -> {
                when (chatItem.from) {
                    UserType.CURRENT_USER -> R.layout.current_user_message
                    UserType.CHAT_USER -> R.layout.chat_user_message
                }
            }
        }
    }
}
