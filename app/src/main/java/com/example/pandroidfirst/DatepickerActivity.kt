package com.example.pandroidfirst

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class DatepickerActivity : AppCompatActivity() {
    private lateinit var btnLoadCalendar: Button
    private lateinit var tvDate:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datepicker)
        btnLoadCalendar=findViewById(R.id.btnLoadCalendar)
        tvDate=findViewById(R.id.tvDate)
        val btnBack:Button=findViewById(R.id.btnBack)
        btnLoadCalendar.setOnClickListener {
            loadCalendar()
        }
        btnBack.setOnClickListener {
            startActivity(Intent(this@DatepickerActivity, MainActivity::class.java))
            finish()
        }

    }
    private fun loadCalendar() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            tvDate.text = "Selected Date:$dayOfMonth/$monthOfYear/$year"
        },
                year,
                month,
                day
        )
        datePickerDialog.show()
    }
}