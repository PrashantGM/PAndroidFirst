package com.example.pandroidfirst

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    //Global variable
    private lateinit var tvOutput:TextView
    private lateinit var etFirst:EditText
    private lateinit var etSecond:EditText
    private lateinit var btnCal:Button
    private lateinit var rbAdd:RadioButton
    private lateinit var rbSubtract:RadioButton
    private lateinit var rbMultiply:RadioButton
    private lateinit var rbDivide:RadioButton
    private lateinit var btnNext:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFirst = findViewById(R.id.etFirst)
        etSecond = findViewById(R.id.etSecond)
        btnCal = findViewById(R.id.btnCal)
        tvOutput = findViewById(R.id.tvOutput)
        rbAdd = findViewById(R.id.rbAdd)

        rbSubtract = findViewById(R.id.rbSubtract)
        rbMultiply = findViewById(R.id.rbMultiply)
        rbDivide = findViewById(R.id.rbDivide)
        btnNext=findViewById(R.id.btnNext)

        btnCal.setOnClickListener {
            if(validate())
                retreive()

        }
        btnNext.setOnClickListener {

            startActivity(Intent(this@MainActivity, SiActivity::class.java))
            finish()

        }
    }
    private fun validate():Boolean{
        var flag=true
        if(TextUtils.isEmpty(etFirst.text)){
            etFirst.error="Enter first number"
            etFirst.requestFocus()
            flag=false
                }
        else if(TextUtils.isEmpty(etSecond.text)){
            etSecond.error="Enter second number"
            etSecond.requestFocus()
            flag=false

        }
        return flag
    }
    private fun retreive(){
        val first:Int=etFirst.text.toString().toInt()
        val second:Int=etSecond.text.toString().toInt()
        val result:Int
        when{
            rbAdd.isChecked->{
                result=add(first,second)
                tvOutput.text=result.toString()
            }
            rbSubtract.isChecked -> {
                result=subtract(first,second)
                tvOutput.text=result.toString()
        }
            rbMultiply.isChecked -> {
                result = multiply(first, second)
                tvOutput.text=result.toString()

            }
            rbDivide.isChecked-> {
                result = divide(first, second)
                tvOutput.text=result.toString()
            }
        }
//        btnNext.isVisible=true

        //            if(rdoAdd.isChecked)
        //Toast.makeText(this, "result is $result", Toast.LENGTH_LONG).show()

    }
    private fun add(first:Int,second:Int):Int{
        return first+second
    }
    private fun subtract(first:Int,second:Int):Int{
        return first-second
    }
    private fun multiply(first:Int,second:Int):Int{
        return first*second
    }
    private fun divide(first:Int,second:Int):Int{
        return first/second
    }
}