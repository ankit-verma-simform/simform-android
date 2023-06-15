package com.example.androiddemoproject.recyclerview.chatscreen.model

import androidx.annotation.DrawableRes
import com.example.androiddemoproject.R

sealed interface Attachment

sealed interface ChatItem

data class LinkAttachment(
    val title: String,
    val description: String? = null,
    val linkUrl: String
) : Attachment

data class ChatMessage(
    val message: String,
    val from: UserType,
    val time: String,
    val date: String,
    @DrawableRes val avatar: Int,
    val isLiked: Boolean = false,
    val attachment: Attachment? = null
) : Attachment,
    ChatItem

enum class UserType {
    CURRENT_USER,
    CHAT_USER
}

data class ChatsDate(
    val date: String
) : ChatItem

fun getChatMessages() = listOf(
    ChatMessage(
        message = "@John Doe Marketers advertisers usually focus their efforts on the people",
        from = UserType.CURRENT_USER,
        time = "6:41 PM",
        date = "19 April 2023",
        avatar = R.drawable.avatar_current_user
    ),
    ChatMessage(
        message = "Ready to get started?",
        from = UserType.CHAT_USER,
        time = "6:41 PM",
        date = "20 April 2023",
        avatar = R.drawable.avatar
    ),
    ChatMessage(
        message = "Sign in! Want to learn more about this application? Take a quick tour.",
        from = UserType.CHAT_USER,
        time = "6:41 PM",
        date = "20 April 2023",
        avatar = R.drawable.avatar
    ),
    ChatMessage(
        message = "Want to go out for lunch today?",
        from = UserType.CURRENT_USER,
        time = "6:41 PM",
        date = "20 April 2023",
        avatar = R.drawable.avatar_current_user,
        isLiked = true
    ),
    ChatMessage(
        message = "https://www.cordico.com/resources/agency/thisisthelink",
        from = UserType.CHAT_USER,
        time = "6:41 PM",
        date = "21 April 2023",
        avatar = R.drawable.avatar
    ),
    ChatMessage(
        message = "I thought the client wanted to include a section about the offer as well? ",
        from = UserType.CURRENT_USER,
        time = "6:41 PM",
        date = "21 April 2023",
        avatar = R.drawable.avatar_current_user
    ),
    ChatMessage(
        message = "Sign in! Want to learn more about this application? Take a quick tour.",
        from = UserType.CURRENT_USER,
        time = "6:41 PM",
        date = "21 April 2023",
        avatar = R.drawable.avatar_current_user,
        attachment = LinkAttachment(
            title = "Brooklyn Simmons",
            description = "Sign in! Want to learn more about this...",
            linkUrl = "www.google.com"
        )
    ),
    ChatMessage(
        message = "Yes, Want to learn more about this app.",
        from = UserType.CHAT_USER,
        time = "6:41 AM",
        date = "19 June 2023",
        avatar = R.drawable.avatar,
        attachment = ChatMessage(
            message = "I will push Krystal to give us solution for the problem we are facing with the clients",
            from = UserType.CURRENT_USER,
            time = "6:41 PM",
            date = "21 April 2023",
            avatar = R.drawable.avatar_current_user,
        )
    ),
)

fun List<ChatMessage>.toChatItems(): List<ChatItem> {
    val messages = this
    val messageGroupByDate = messages.groupBy { it.date }
    val chatItems = mutableListOf<ChatItem>()
    for ((date, chatMessages) in messageGroupByDate) {
        chatItems.add(ChatsDate(date))
        chatItems.addAll(chatMessages)
    }
    return chatItems
}
