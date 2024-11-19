package com.example.jusvacapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ConsultaMedicaDosActivity : AppCompatActivity() {

        private lateinit var tvSelectedDate: TextView
        private lateinit var btnSelectDate: MaterialButton
        private lateinit var tvSelectedTime: TextView
        private lateinit var btnSelectTime: MaterialButton

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.consulta_medica_dos)

            tvSelectedDate = findViewById(R.id.tvSelectedDate)
            btnSelectDate = findViewById(R.id.btnSelectDate)
            tvSelectedTime = findViewById(R.id.tvSelectedTime)
            btnSelectTime = findViewById(R.id.btnSelectTime)

            btnSelectDate.setOnClickListener {
                showMaterialDatePicker()
            }

            btnSelectTime.setOnClickListener {
                showMaterialTimePicker()
            }
        }

        private fun showMaterialDatePicker() {
            // Crear un selector de fecha con Material Design
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selecciona una fecha:")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()

            // Mostrar el selector de fecha
            datePicker.show(supportFragmentManager, "MATERIAL_DATE_PICKER")

            // Manejar la fecha seleccionada
            datePicker.addOnPositiveButtonClickListener { selection ->
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val selectedDate = sdf.format(Date(selection))
                val calendar = Calendar.getInstance()
                calendar.time = sdf.parse(selectedDate)
                calendar.add(Calendar.DAY_OF_MONTH, 1)
                val newDate = sdf.format(calendar.time)

                tvSelectedDate.text = "Fecha seleccionada: $newDate"
            }
        }

        private fun showMaterialTimePicker() {
            // Crear un selector de hora con Material Design
            val timePicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H) // Formato de 24 horas
                .setHour(12) // Hora inicial
                .setMinute(0) // Minuto inicial
                .setTitleText("Selecciona una hora:")
                .build()

            // Mostrar el selector de hora
            timePicker.show(supportFragmentManager, "MATERIAL_TIME_PICKER")

            // Manejar la hora seleccionada
            timePicker.addOnPositiveButtonClickListener {
                val selectedTime = "${timePicker.hour}:${timePicker.minute}"
                tvSelectedTime.text = "Hora seleccionada: $selectedTime"
            }
        }
}
    
