package com.example.jusvacapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegistroActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.registro)

        val txtFieldCedula = findViewById<TextInputLayout>(R.id.txtFieldCedula)
        val editTextCedula = txtFieldCedula.editText as TextInputEditText
        val btnRegistrarte = findViewById<Button>(R.id.btnRegistrarse)


        editTextCedula.filters = arrayOf(InputFilter.LengthFilter(10))



        btnRegistrarte.setOnClickListener {
            Toast.makeText(this, "Bienvenido a nuestra App!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
        }

        editTextCedula.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val input = s.toString()
                if (!input.all { it.isDigit() }) {
                    editTextCedula.error = "Solo se permiten números"
                } else {
                    editTextCedula.error = null // Limpiar el error si la entrada es válida
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

    }
}