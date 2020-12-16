package com.example.pandroidfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
class ListviewActivity : AppCompatActivity() {
    private val countries = arrayOf("Nepal", "India", "England")
    private lateinit var lstView:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)
        lstView=findViewById(R.id.listView)
        val adapter = ArrayAdapter<String>(
                applicationContext, android.R.layout.simple_list_item_1, countries
        )
        lstView.adapter = adapter
        lstView.setOnItemClickListener{
                    parent,
                    view,
                    position,
                    id->

                val element = parent?.getItemIdAtPosition(position).toString()
                Toast.makeText(
                        this@ListviewActivity,
                        "Selected item:$element",
                        Toast.LENGTH_SHORT
                ).show()

            }


        }
}