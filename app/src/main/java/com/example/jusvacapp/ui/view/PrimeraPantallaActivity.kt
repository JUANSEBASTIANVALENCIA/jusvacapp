package com.example.jusvacapp.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.jusvacapp.databinding.ActivityPrimeraPantallaBinding

class PrimeraPantallaActivity : AppCompatActivity() {

    private lateinit var binding:ActivityPrimeraPantallaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPrimeraPantallaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIniciarE.setOnClickListener {
            Toast.makeText(this, "¡¡Bienvenido a Jusvac!!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, IniciarSesionActivity::class.java)
            startActivity(intent)
        }
    }
}