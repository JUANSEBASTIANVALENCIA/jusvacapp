package com.example.jusvacapp
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class iniciar: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.iniciar_sesion)

        val btnIniciarE = findViewById<Button>(R.id.btnIniciarE)
        btnIniciarE.setOnClickListener {

            Toast.makeText(this, "¡¡Bienvenido a Jusvac!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, iniciar::class.java)
            startActivity(intent)
        }
    }
}