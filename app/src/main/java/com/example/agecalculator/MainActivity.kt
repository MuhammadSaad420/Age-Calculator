package com.example.agecalculator

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    var dateLabel: TextView? = null;
    var minLabel: TextView? = null;
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker);
        dateLabel = findViewById(R.id.dateLabel);
        minLabel = findViewById(R.id.minText);
        val calender = Calendar.getInstance();
        val year = calender.get(Calendar.YEAR);
        val month = calender.get(Calendar.MONTH);
        val day = calender.get(Calendar.DAY_OF_MONTH);
        btnDatePicker.setOnClickListener {

            val dpd = DatePickerDialog(this,{ view, year, month, dayOfMonth ->
                val displayedDate = "$dayOfMonth/${month+1}/$year";

            dateLabel?.text = displayedDate;
                val dateParser = SimpleDateFormat("dd/MM/yyyy");
                val dateObject = dateParser.parse(displayedDate);
                dateObject?.let {
                    val selectedDateInMinutes = dateObject.time/60000;
                    val currentDate =dateParser.parse(dateParser.format(System.currentTimeMillis()));
                    currentDate?.let {
                        val currentDateInMinutes = currentDate.time/60000;
                        val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes;
                        minLabel?.text = differenceInMinutes.toString();
                    }
                }
            },year,month, day);
            dpd
                .datePicker.maxDate = System.currentTimeMillis() - 86400000
            dpd.show();
        }
    }
}