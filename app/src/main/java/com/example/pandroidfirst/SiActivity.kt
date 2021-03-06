package com.example.pandroidfirst

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
class SiActivity : AppCompatActivity() {
    //Global variable
    private lateinit var etPrincipal: EditText
    private lateinit var etTime: EditText
    private lateinit var etRate: EditText
    private lateinit var btnCal: Button
    private lateinit var tvOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_si)
        etPrincipal = findViewById(R.id.etPrincipal)
        etTime = findViewById((R.id.etTime))
        etRate = findViewById((R.id.etRate))
        btnCal=findViewById(R.id.btnCal)
        tvOutput=findViewById(R.id.tvOutput)
        val btnBack:Button=findViewById(R.id.btnBack)

        btnCal.setOnClickListener {
            val si:Float
            si=calculatesi()
            tvOutput.text = "Simple Interest is $si"

        }
        btnBack.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }
        private fun calculatesi(): Float {

            val p = etPrincipal.text.toString().toFloat()
            val t = etTime.text.toString().toFloat()
            val r = etRate.text.toString().toFloat()

           return (p * t * r) / 100

    }
}