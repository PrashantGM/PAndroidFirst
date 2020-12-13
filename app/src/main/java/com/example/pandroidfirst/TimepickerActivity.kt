package com.example.pandroidfirst

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class TimepickerActivity : AppCompatActivity() {
    private lateinit var btnLoadTimePicker: Button
    private lateinit var tvTime: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timepicker)

        btnLoadTimePicker = findViewById(R.id.btnLoadTimePicker)
        tvTime = findViewById(R.id.tvTime)
        val btnBack:Button=findViewById(R.id.btnBack)

        btnLoadTimePicker.setOnClickListener {
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)
            val timePickerDialog = TimePickerDialog(
                    this,
                    TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                        tvTime.text = "$hour:$minute"
                    },
                    hour,
                    minute,
                    true
            )
            timePickerDialog.show()
        }
        btnBack.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }
}
