package com.example.jusvacapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class EspecialistaUnoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.especialista)

        val txtFieldTelefono = findViewById<TextInputLayout>(R.id.txtFieldTelefono)
        val imageFlecha = findViewById<ImageView>(R.id.imageFlecha)
        val editTextTelefono = txtFieldTelefono.editText as TextInputEditText

        editTextTelefono.filters = arrayOf(InputFilter.LengthFilter(10))


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

        imageFlecha.setOnClickListener {

            Toast.makeText(this, "¡¡Agendate segùn tus comodidades!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, EspecialistasDosActivity::class.java) // Cambiado a IniciarSesionActivity
            startActivity(intent)
        }
    }
}