package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_todo.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter= ToDoAdapter(mutableListOf())

        rvToDoItems.adapter = todoAdapter

        rvToDoItems.layoutManager = LinearLayoutManager(this)

        BtnAddToDo.setOnClickListener {
            val todoTitle = edToEditTitle.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = ToDo(todoTitle)
                todoAdapter.addToDo(todo)
                edToEditTitle.text.clear()
            }
        }

        BtnDelete.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}