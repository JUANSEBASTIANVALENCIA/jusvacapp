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

            val btnIniciar = findViewById<Button>(R.id.btnIniciarE)
            btnIniciar.setOnClickListener {

            Toast.makeText(this, "Bienvenido a nuestra App!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}