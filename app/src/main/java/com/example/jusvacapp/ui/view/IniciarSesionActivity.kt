package com.example.jusvacapp.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.jusvacapp.R
import com.example.jusvacapp.data.dto.LoginDTO
import com.example.jusvacapp.data.utils.Utils
import com.example.jusvacapp.databinding.IniciarSesionBinding
import com.example.jusvacapp.ui.viewmodel.LoginViewModel

class IniciarSesionActivity : AppCompatActivity() {

    private lateinit var binding: IniciarSesionBinding
    private val loginViewModel: LoginViewModel by viewModels()
    private val utils: Utils = Utils()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = IniciarSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // NO VA AQUIIIIIII
        loginViewModel.getConsultas()

        val txtEresNUevo = findViewById<TextView>(R.id.txtEresNuevo)
        // Seccion de observadores
        loginViewModel.isLoading.observe(this, Observer {
            binding.pgBar.isVisible = it
        })

        loginViewModel.message.observe(this, Observer {
            if (it != null) {
                showToastDialog(it)
            }
        })

        loginViewModel.userModel.observe(this, Observer {
            if (it != null) {
                val intent = Intent(this, PrincipalActivity::class.java)
                startActivity(intent)
            }
        })

        binding.btnIngresar.setOnClickListener {
            Toast.makeText(this, "Bienvenido a nuestra App!!", Toast.LENGTH_SHORT).show()
            if (validateData()) {
                when {
                    utils.isConnected(binding.root.context) -> {
                        val user: String = binding.etCorreo.text.toString()
                        val password: String = binding.etPassword.text.toString()

                        val loginDTO = LoginDTO(user, password)
                        loginViewModel.login(loginDTO)
                    }

                    !utils.isConnected(binding.root.context) -> {
                        showToastDialog("No tienes conexión a internet \uD83D\uDE32 !")
                    }
                }
            }

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

    private fun showToastDialog(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun validateData(): Boolean {
        var isValid = true
        with(binding){
            // validar el null del campo correo
            if (etCorreo.text.toString().isBlank()){
                isValid = false
                etCorreo.error = "Campo requerido"
            } else {
                etCorreo.error = null
            }
            // validar el null del campo contraseña
            if (etPassword.text.toString().isBlank()){
                isValid = false
                etPassword.error = "Campo requerido"
            } else {
                etPassword.error = null
            }
        }
        return isValid
    }

}