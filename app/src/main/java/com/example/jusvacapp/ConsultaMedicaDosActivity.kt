package com.example.jusvacapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ConsultaMedicaDosActivity : AppCompatActivity() {

        private lateinit var tvSelectedDate: TextView
        private lateinit var btnSelectDate: MaterialButton

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.consulta_medica_dos)

            tvSelectedDate = findViewById(R.id.tvSelectedDate)
            btnSelectDate = findViewById(R.id.btnSelectDate)

            btnSelectDate.setOnClickListener {
                showMaterialDatePicker()
            }
        }

        private fun showMaterialDatePicker() {
            // Crear un selector de fecha con Material Design
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selecciona una fecha")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()

            // Mostrar el selector de fecha
            datePicker.show(supportFragmentManager, "MATERIAL_DATE_PICKER")

            // Manejar la fecha seleccionada
            datePicker.addOnPositiveButtonClickListener { selection ->
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val selectedDate = sdf.format(Date(selection))
                tvSelectedDate.text = "Fecha seleccionada: $selectedDate"
            }
        }
    }
    
