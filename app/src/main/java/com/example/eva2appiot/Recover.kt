package com.example.eva2appiot

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import android.widget.TextView

class Recover : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover)

        val tvVolverLogin = findViewById<TextView>(R.id.tvVolverLogin)
        tvVolverLogin.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
        }

        val email = findViewById<EditText>(R.id.etEmailRec)
        val btnSend = findViewById<Button>(R.id.btnSend)

        btnSend.setOnClickListener {
            val e = email.text.toString()
            if (e.isBlank() || !e.contains("@")) {
                showAlert("Email inválido", "Ingresa un email válido.")
            } else {
                showAlert("Recuperación enviada", "Se envió un correo de recuperación.")
            }
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
