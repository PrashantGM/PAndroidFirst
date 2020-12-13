package com.example.pandroidfirst

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class SpinnerActivity : AppCompatActivity() {
    private val languages = arrayOf("Nepali", "Hindi", "English")
    private lateinit var spinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)
        spinner = findViewById((R.id.spnLang))
        val btnBack: Button =findViewById(R.id.btnBack)

        val adapter = ArrayAdapter<String>(
                applicationContext, android.R.layout.simple_list_item_1, languages
        )
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
            ) {
                val selectedItem = parent?.getItemIdAtPosition(position).toString()
                Toast.makeText(
                        this@SpinnerActivity,
                        "Selected item:$selectedItem",
                        Toast.LENGTH_SHORT
                ).show()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        btnBack.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }

}