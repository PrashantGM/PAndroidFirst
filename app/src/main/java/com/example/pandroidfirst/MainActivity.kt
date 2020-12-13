package com.example.pandroidfirst

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    //Global variable
    private lateinit var rbDatePicker:RadioButton
    private lateinit var rbTimePicker:RadioButton
    private lateinit var rbAlertDialog:RadioButton
    private lateinit var rbGrid:RadioButton
    private lateinit var rbMessage:RadioButton
    private lateinit var rbDMAS:RadioButton
    private lateinit var rbSpinner:RadioButton
    private lateinit var rbUserProfile:RadioButton
    private lateinit var tvTitle:TextView
    private lateinit var btnRun:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rbDatePicker=findViewById(R.id.rbDatePicker)
        rbTimePicker=findViewById(R.id.rbTimePicker)
        rbAlertDialog=findViewById(R.id.rbAlertDialog)
        rbGrid=findViewById(R.id.rbGrid)
        rbMessage=findViewById(R.id.rbMessage)
        rbDMAS=findViewById(R.id.rbDMAS)
        rbSpinner=findViewById(R.id.rbSpinner)
        rbUserProfile=findViewById(R.id.rbUserProfile)
        tvTitle=findViewById(R.id.tvTitle)
        btnRun=findViewById(R.id.btnRun)

        btnRun.setOnClickListener {

            if(rbDatePicker.isChecked)
            {
                startActivity(Intent(this@MainActivity, DatepickerActivity::class.java))
            }
            else if(rbAlertDialog.isChecked){
                startActivity(Intent(this@MainActivity, AlertDialogActivity::class.java))
            }
            else if(rbGrid.isChecked){
                startActivity(Intent(this@MainActivity, GridActivity::class.java))
            } else if(rbMessage.isChecked){
                startActivity(Intent(this@MainActivity, MessageActivity::class.java))
            } else if(rbDMAS.isChecked){
                startActivity(Intent(this@MainActivity, DMASActivity::class.java))
            } else if(rbSpinner.isChecked){
                startActivity(Intent(this@MainActivity, SpinnerActivity::class.java))
            }
             else if(rbUserProfile.isChecked){
                startActivity(Intent(this@MainActivity, UserProfileActivity::class.java))
            }
            else if(rbTimePicker.isChecked){
                startActivity(Intent(this@MainActivity, TimepickerActivity::class.java))
            }
            else {
                startActivity(Intent(this@MainActivity, SiActivity::class.java))
            }
            finish()

        }
    }
}