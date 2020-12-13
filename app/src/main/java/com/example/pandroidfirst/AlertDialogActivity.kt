package com.example.pandroidfirst

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        val button:Button=findViewById(R.id.btnAlert)
        val btnBack:Button=findViewById(R.id.btnBack)
        button.setOnClickListener {
            val builder=AlertDialog.Builder(this)
            builder.setTitle("My Alert")
            builder.setMessage("Are you sure?")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("YEs"){dialogInterface,which->
                Toast.makeText(applicationContext,"clickedk yes", Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel"){ dialogInterface, which->
                Toast.makeText(applicationContext,"clciked Cancel \n operation cancel", Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("No"){dialogInterface,which->
                Toast.makeText(applicationContext,"clciked No", Toast.LENGTH_LONG).show()
            }
            val alertDialog:AlertDialog=builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
        btnBack.setOnClickListener {
            startActivity(Intent(this@AlertDialogActivity, MainActivity::class.java))
            finish()
        }
    }
}