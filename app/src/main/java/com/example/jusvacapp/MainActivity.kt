package com.example.jusvacapp
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.iniciar)

        val btnIniciarE = findViewById<Button>(R.id.btnIniciarE)
        btnIniciarE.setOnClickListener {

            Toast.makeText(this, "¡¡Inicia sesión o Registrate y disfruta de nuestros servicios!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, IniciarSesionActivity::class.java) // Cambiado a IniciarSesionActivity
            startActivity(intent)
        }
    }

    private fun enableEdgeToEdge() {
        // Implementación de la función si es necesario
    }
}
