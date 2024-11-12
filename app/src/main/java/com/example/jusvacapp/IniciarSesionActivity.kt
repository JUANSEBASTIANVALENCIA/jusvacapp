package com.example.jusvacapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class IniciarSesionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.iniciar_sesion)

        val btnIngresar = findViewById<Button>(R.id.btnIngresar)
        val txtEresNUevo = findViewById<TextView>(R.id.txtEresNuevo)


        btnIngresar.setOnClickListener {
            Toast.makeText(this, "Bienvenido a nuestra App!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
        }


        txtEresNUevo.setOnClickListener {

            Toast.makeText(this, "¡¡Registrate y sé parte de Jusvac!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, RegistroActivity::class.java) // Cambiado a IniciarSesionActivity
            startActivity(intent)
        }
    }

    private fun enableEdgeToEdge() {
        // Implementación de la función si es necesario
    }
}