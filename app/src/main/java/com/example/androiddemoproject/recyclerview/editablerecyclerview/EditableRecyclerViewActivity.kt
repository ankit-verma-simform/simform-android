package com.example.androiddemoproject.recyclerview.editablerecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemoproject.databinding.ActivityEditableRecyclerViewBinding

class EditableRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditableRecyclerViewBinding
    private val todos = mutableListOf(
        Todo("Learn Android"),
        Todo("Play Chess"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditableRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        setupAddTodoListener()
    }

    private fun setupAddTodoListener() {
        binding.inputTodo.setEndIconOnClickListener {
            addTodo()
        }
    }

    private fun addTodo() {
        val todo = binding.inputTodo.editText?.text.toString()
        if (todo.isNotEmpty()) {
            todos.add(Todo(todo))
            binding.rvTodos.adapter?.notifyItemInserted(todos.lastIndex)
            binding.inputTodo.editText?.text?.clear()
            binding.rvTodos.scrollToPosition(todos.lastIndex)
        }
    }

    private fun setupRecyclerView() {
        binding.rvTodos.adapter = TodoAdapter(this, todos)
    }
}