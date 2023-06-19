package com.example.androiddemoproject.recyclerview.editablerecyclerview

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemoproject.databinding.EditTodoDialogBinding
import com.example.androiddemoproject.databinding.TodoItemBinding

class TodoAdapter(
    val context: Context,
    private val todos: MutableList<Todo> = mutableListOf()
) :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TodoItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = todos[position]
        with(holder.binding) {
            checkboxIsCompleted.isChecked = todo.isCompleted
            tvTodo.text = if (todo.isCompleted) {
                SpannableString(todo.text).apply {
                    setSpan(
                        StrikethroughSpan(),
                        0,
                        todo.text.length,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }
            } else {
                todo.text
            }
            checkboxIsCompleted.setOnClickListener {
                todo.isCompleted = !todo.isCompleted
                notifyItemChanged(position)
            }
            imgDeleteTodo.setOnClickListener {
                todos.remove(todo)
                notifyItemRemoved(position)
            }
            imgEditTodo.setOnClickListener {
                showEditTodoDialog(todo, position)
            }
        }
    }

    private fun showEditTodoDialog(todo: Todo, position: Int) {
        val binding = EditTodoDialogBinding.inflate(LayoutInflater.from(context))
        binding.inputTodo.editText?.setText(todo.text)

        AlertDialog.Builder(context)
            .setTitle("Edit Todo")
            .setView(binding.root)
            .setPositiveButton("OK") { _, _ ->
                binding.inputTodo.editText?.text?.let {
                    todos[position] = todo.copy(text = it.toString())
                    notifyItemChanged(position)
                }
            }.setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
