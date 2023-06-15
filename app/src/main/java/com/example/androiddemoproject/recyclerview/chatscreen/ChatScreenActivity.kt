package com.example.androiddemoproject.recyclerview.chatscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityChatScreenBinding
import com.example.androiddemoproject.recyclerview.chatscreen.adapter.ChatAdapter
import com.example.androiddemoproject.recyclerview.chatscreen.model.ChatMessage
import com.example.androiddemoproject.recyclerview.chatscreen.model.UserType
import com.example.androiddemoproject.recyclerview.chatscreen.model.getChatMessages
import com.example.androiddemoproject.recyclerview.chatscreen.model.toChatItems
import com.example.androiddemoproject.recyclerview.chatscreen.utils.ChatMessageItemDecoration
import com.example.androiddemoproject.recyclerview.chatscreen.utils.getCurrentDateTime

class ChatScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatScreenBinding
    private val chatAdapter by lazy { ChatAdapter() }
    private val messages by lazy { getChatMessages().toMutableList() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialSetups()
    }

    private fun initialSetups() {
        setupChatsRecyclerView()
        setupSendMessageListener()
        setupChatInputEditText()
        setupAppbar()
    }

    private fun setupAppbar() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupChatInputEditText() {
        binding.etChatInput.apply {
            setOnFocusChangeListener { _, _ ->
                binding.rvChats.let {
                    val lastIndex = (it.adapter as ChatAdapter).currentList.lastIndex
                    it.postDelayed({
                        it.smoothScrollToPosition(lastIndex)
                        // give a delay of one second before scrolling
                    }, 1000)
                }
            }
        }
    }

    private fun setupSendMessageListener() {
        binding.imgBtnSendChat.setOnClickListener {
            val newChatMessageString = binding.etChatInput.text.toString()
            if (newChatMessageString.isBlank()) {
                return@setOnClickListener
            }
            val (date, time) = getCurrentDateTime()
            val newChatMessage = ChatMessage(
                message = newChatMessageString,
                from = UserType.CURRENT_USER,
                time = time,
                date = date,
                avatar = R.drawable.avatar_current_user
            )
            messages.add(newChatMessage)
            val newChatItems = messages.toChatItems()
            chatAdapter.submitList(newChatItems)
            binding.rvChats.smoothScrollToPosition(newChatItems.size - 1)
            binding.etChatInput.text.clear()
        }
    }

    private fun setupChatsRecyclerView() {
        chatAdapter.submitList(messages.toChatItems())
        binding.rvChats.apply {
            layoutManager = LinearLayoutManager(this@ChatScreenActivity, VERTICAL, false)
            adapter = chatAdapter
            addItemDecoration(ChatMessageItemDecoration())
            smoothScrollToPosition(chatAdapter.currentList.lastIndex)
        }
    }
}
