package com.example.androiddemoproject.recyclerview.chatscreen.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.androiddemoproject.databinding.ChatUserMessageBinding
import com.example.androiddemoproject.databinding.ChatsDateItemBinding
import com.example.androiddemoproject.databinding.CurrentUserMessageBinding
import com.example.androiddemoproject.recyclerview.chatscreen.model.ChatMessage
import com.example.androiddemoproject.recyclerview.chatscreen.model.ChatsDate
import com.example.androiddemoproject.recyclerview.chatscreen.model.LinkAttachment
import com.example.androiddemoproject.recyclerview.chatscreen.model.UserType
import com.example.androiddemoproject.recyclerview.chatscreen.utils.getCurrentDateTime

sealed class ChatViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    class CurrentUserChatViewHolder(val binding: CurrentUserMessageBinding) :
        ChatViewHolder(binding) {

        fun bind(chatMessage: ChatMessage) {
            with(binding) {
                tvChatTime.text = chatMessage.time
                tvMessage.text = chatMessage.message
                imgChatLike.visibility = if (chatMessage.isLiked) View.VISIBLE else View.GONE

                llAttachment.visibility =
                    if (chatMessage.attachment == null) View.GONE else View.VISIBLE
                val attachment = chatMessage.attachment ?: return
                when (attachment) {
                    is ChatMessage -> {
                        tvAttachmentTitle.text = if (attachment.from == UserType.CURRENT_USER) {
                            "You"
                        } else {
                            "Cameron W."
                        }
                        tvAttachmentDescription.text = attachment.message
                    }

                    is LinkAttachment -> {
                        tvAttachmentTitle.text = attachment.title
                        tvAttachmentDescription.text = attachment.description
                    }
                }
            }
        }
    }

    class ChatUserChatViewHolder(val binding: ChatUserMessageBinding) :
        ChatViewHolder(binding) {

        fun bind(chatMessage: ChatMessage) {
            with(binding) {
                tvChatTime.text = chatMessage.time
                tvMessage.text = chatMessage.message
                imgChatLike.visibility = if (chatMessage.isLiked) View.VISIBLE else View.GONE

                llAttachment.visibility =
                    if (chatMessage.attachment == null) View.GONE else View.VISIBLE
                val attachment = chatMessage.attachment ?: return
                when (attachment) {
                    is ChatMessage -> {
                        tvAttachmentTitle.text = if (attachment.from == UserType.CURRENT_USER) {
                            "You"
                        } else {
                            "Cameron W."
                        }
                        tvAttachmentDescription.text = attachment.message
                    }

                    is LinkAttachment -> {
                        tvAttachmentTitle.text = attachment.title
                        tvAttachmentDescription.text = attachment.description
                    }
                }
            }
        }
    }

    class ChatsDateViewHolder(val binding: ChatsDateItemBinding) : ChatViewHolder(binding) {
        fun bind(chatsDate: ChatsDate) {
            with(binding) {
                val messageSentToday = chatsDate.date == getCurrentDateTime().first
                tvChatDate.text = if (messageSentToday) "Today" else chatsDate.date
            }
        }
    }
}
