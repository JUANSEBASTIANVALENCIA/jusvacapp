package com.example.jusvacapp


import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.principal)

        val imageConsultaMedica = findViewById<ImageView>(R.id.imageConsultaMedica)
        val imageEnfermeria = findViewById<ImageView>(R.id.imageEnfermeria)
        val imageEspecialista = findViewById<ImageView>(R.id.imageEspecialista)



        imageConsultaMedica.setOnClickListener {

            Toast.makeText(this, "¡¡Registrate y haz tu consulta!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,  ConsultaMedicaUnoActivity::class.java) // Cambiado a IniciarSesionActivity
            startActivity(intent)
        }


        imageEnfermeria.setOnClickListener {
            Toast.makeText(this, "¡¡Registrate y adquiere tu enfermero!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,  EnfermeriaUnoActivity::class.java) // Cambiado a IniciarSesionActivity
            startActivity(intent)

        }

        imageEspecialista.setOnClickListener {

            Toast.makeText(this, "¡¡Registrate y adquiere tu especialista!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, EspecialistaUnoActivity::class.java) // Cambiado a IniciarSesionActivity
            startActivity(intent)
        }
    }

    private fun enableEdgeToEdge() {
        // Implementación de la función si es necesario
    }
}