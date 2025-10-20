package com.example.eva2appiot

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.EditText
import android.widget.Button

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.etEmail)
        val pass = findViewById<EditText>(R.id.etPass)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvNoAccount = findViewById<TextView>(R.id.tvNoAccount)
        val tvForgot = findViewById<TextView>(R.id.tvForgot)


        btnLogin.setOnClickListener {
            val emailText = email.text.toString().trim()
            val passText = pass.text.toString().trim()

            if (emailText.isEmpty() || passText.isEmpty()) {
                showAlert("Campos vacíos", "Ingresa tu email y contraseña.")
            } else {
                showAlert("Saludo especial", "¡Hola $emailText, bienvenido a mi aplicación!")
            }
        }

        tvNoAccount.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }

        tvForgot.setOnClickListener {
            startActivity(Intent(this, Recover::class.java))
        }
    }

    private fun showAlert(title: String, message: String) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}
