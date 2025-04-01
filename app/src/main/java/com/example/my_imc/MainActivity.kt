package com.example.my_imc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Referências aos componentes do layout
        val alturaInput: EditText = findViewById<EditText>(R.id.alturaInput)
        val pesoInput: EditText = findViewById<EditText>(R.id.pesoInput)
        val calcularButton: Button = findViewById<Button>(R.id.calcularButton)
        val resultadoText: TextView = findViewById<TextView>(R.id.resultadoText)

        // Evento do clique no botão "Calcular IMC"
        calcularButton.setOnClickListener {
            val altura = alturaInput?.text.toString().toFloatOrNull()?.div(100)
            val peso = pesoInput?.text.toString().toIntOrNull()
            if (altura != null && peso != null) {
                // Cálculo do IMC
                val imc = peso / (altura * altura)
                resultadoText.text = "Seu IMC é: %.2f".format(imc)
            } else {
                // Exibe mensagem de erro se os valores não forem válidos
                Toast.makeText(this, "Por favor, insira valores válidos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
