package com.example.jusvacapp.ui.view

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jusvacapp.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ConsultaMedicaDosActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.consulta_medica_dos)

            val etFecha = findViewById<TextInputEditText>(R.id.etFecha)
            val etHora = findViewById<TextInputEditText>(R.id.etHora)
            val btnAgendar = findViewById<Button>(R.id.btnAgendar)
            val btnActualizar = findViewById<Button>(R.id.btnActualizar)

            etFecha.setOnClickListener {
                mostrarDatePicker(etFecha)
            }

            etHora.setOnClickListener {
                mostrarTimePicker(etHora)
            }

            btnAgendar.setOnClickListener {
                Toast.makeText(this, "¡Tu consulta ha sido agendada!", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }

            btnActualizar.setOnClickListener {
                Toast.makeText(this, "¡Lista de tus consultas!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ListaActivity::class.java)
                startActivity(intent)
            }
        }

        private fun mostrarDatePicker(etFecha: TextInputEditText) {
            val calendario = Calendar.getInstance()

            // Crear DatePickerDialog
            val datePicker = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    val fechaSeleccionada = "$dayOfMonth/${month + 1}/$year"
                    etFecha.setText(fechaSeleccionada)
                },
                calendario.get(Calendar.YEAR),
                calendario.get(Calendar.MONTH),
                calendario.get(Calendar.DAY_OF_MONTH)
            )

            datePicker.show()
        }

        private fun mostrarTimePicker(etHora: TextInputEditText) {
            val calendario = Calendar.getInstance()
            val horaActual = calendario.get(Calendar.HOUR_OF_DAY)
            val minutoActual = calendario.get(Calendar.MINUTE)

            // Crear TimePickerDialog
            val timePicker = TimePickerDialog(
                this,
                { _, hourOfDay, minute ->
                    val horaFormateada = String.format("%02d:%02d", hourOfDay, minute)
                    etHora.setText(horaFormateada)
                },
                horaActual,
                minutoActual,
                true // Usa formato de 24 horas; cambia a false para 12 horas.
            )

            timePicker.show()
        }
}
    
