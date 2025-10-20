package com.example.eva2appiot

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val name = findViewById<EditText>(R.id.etName)
        val email = findViewById<EditText>(R.id.etEmailReg)
        val pass = findViewById<EditText>(R.id.etPassReg)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val tvHaveAccount = findViewById<TextView>(R.id.tvHaveAccount)

        btnRegister.setOnClickListener {
            if (name.text.isBlank() || email.text.isBlank() || pass.text.isBlank()) {
                showAlert("Error", "Por favor completa todos los campos.")
            } else {
                showAlert("Cuenta creada", "Registro exitoso.")
            }
        }

        tvHaveAccount.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
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
