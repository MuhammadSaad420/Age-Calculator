package com.example.agecalculator

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker);
        val calender = Calendar.getInstance();
        val year = calender.get(Calendar.YEAR);
        val month = calender.get(Calendar.MONTH);
        val day = calender.get(Calendar.DAY_OF_MONTH);
        btnDatePicker.setOnClickListener {
            DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

            },year,month, day).show()
        }
    }
}