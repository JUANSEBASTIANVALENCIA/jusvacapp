package com.example.jusvacapp.ui.view

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.jusvacapp.R
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar

class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista)

        val editTextNombre = findViewById<TextInputEditText>(R.id.editTextNombrePaciente)
        val editTextUbicacion = findViewById<TextInputEditText>(R.id.editTextUbicacion)
        val editTextTelefono = findViewById<TextInputEditText>(R.id.editTextTelefono)
        val etFecha = findViewById<TextInputEditText>(R.id.etFecha)
        val etHora = findViewById<TextInputEditText>(R.id.etHora)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnEliminar = findViewById<Button>(R.id.btnEliminar)

        etFecha.setOnClickListener {
            mostrarDatePicker(etFecha)
        }

        etHora.setOnClickListener {
            mostrarTimePicker(etHora)
        }

        btnGuardar.setOnClickListener {
            val nombrePaciente = editTextNombre.text.toString().trim()
            val ubicacion = editTextUbicacion.text.toString().trim()
            val telefono = editTextTelefono.text.toString().trim()
            val fecha = etFecha.text.toString().trim()
            val hora = etHora.text.toString().trim()

            when {
                nombrePaciente.isEmpty() -> {
                    Toast.makeText(
                        this,
                        "Por favor ingresa el nombre del paciente",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                ubicacion.isEmpty() -> {
                    Toast.makeText(
                        this,
                        "Por favor ingresa la ubicación del paciente",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                telefono.isEmpty() -> {
                    Toast.makeText(
                        this,
                        "Por favor ingresa el teléfono del paciente",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                fecha.isEmpty() -> {
                    Toast.makeText(
                        this,
                        "Por favor ingresa la fecha",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                hora.isEmpty() -> {
                    Toast.makeText(
                        this,
                        "Por favor ingresa la hora",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    // Todos los campos están llenos
                    Toast.makeText(
                        this,
                        "Datos guardados: $nombrePaciente, $ubicacion, $telefono, $fecha, $hora",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        btnEliminar.setOnClickListener {
            Toast.makeText(this, "¡Tu consulta ha sido eliminada!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        editTextTelefono.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Verificar que solo contenga números
                val input = s.toString()
                if (!input.all { it.isDigit() }) {
                    editTextTelefono.error = "Solo se permiten números"
                } else {
                    editTextTelefono.error = null // Limpiar el error si la entrada es válida
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
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