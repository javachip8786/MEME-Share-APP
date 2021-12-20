package com.example.todolist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.icu.text.CaseMap
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*


class ToDoAdapter(
    private val todos: MutableList<ToDo>

) : RecyclerView.Adapter<ToDoAdapter.todoViewHolder>(){
    class todoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoViewHolder {
        return todoViewHolder(
            return todoViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_todo,
                    parent,
                    false
                )
            )
        )
    }

    fun addToDo(todo: ToDo){
        todos.add(todo)
        notifyItemInserted(todos.size-1)
    }

    fun deleteDoneTodos(){
        todos.removeAll { todo ->
            todo.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStringThough(tvTodoTitle: TextView, ischecked: Boolean){
        if(ischecked){
            tvTodoTitle.paintFlags= tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        }
        else{
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: todoViewHolder, position: Int) {
        var currtodo = todos[position]
        holder.itemView.apply {
            tvToDoTitle.text = currtodo.title
            cbDone.isChecked = currtodo.isChecked
            toggleStringThough(tvToDoTitle,currtodo.isChecked)
            cbDone.setOnCheckedChangeListener { _, isChecked ->
                toggleStringThough(tvToDoTitle, isChecked)
                currtodo.isChecked = !currtodo.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

}