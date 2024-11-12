package com.example.jusvacapp


import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.principal)

        val txtViewConsulta = findViewById<TextView>(R.id.txtViewConsultaMedica)
        val txtViewEspecialista = findViewById<TextView>(R.id.txtViewEspecialista)


        txtViewConsulta.setOnClickListener {

            Toast.makeText(this, "¡¡Registrate y sé parte de Jusvac!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,  ConsultaMedicaUnoActivity::class.java) // Cambiado a IniciarSesionActivity
            startActivity(intent)
        }


        txtViewEspecialista.setOnClickListener {

            Toast.makeText(this, "¡¡Registrate y sé parte de Jusvac!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, EspecialistaUnoActivity::class.java) // Cambiado a IniciarSesionActivity
            startActivity(intent)
        }
    }

    private fun enableEdgeToEdge() {
        // Implementación de la función si es necesario
    }
}