package com.victor.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText

    private lateinit var textInputGas: TextInputLayout
    private lateinit var editGas: TextInputEditText

    private lateinit var btnCalc: Button
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewsComponents()
        btnCalc.setOnClickListener {
            calcBestPrice()
        }
    }

    private fun calcBestPrice() {
        val priceAlcool = editAlcool.text.toString()
        val priceGas = editGas.text.toString()

        val isValidated = validadeFilds(priceAlcool, priceGas)
        if (isValidated) {
            val priceAlcoolDouble = priceAlcool.toDouble()
            val priceGasDouble = priceGas.toDouble()

            val total = priceAlcoolDouble / priceGasDouble

            if (total >= 0.7) textResult.text = "Melhor utilizar Gasolina"
            else textResult.text = "Melhor utilizar Alcool"
        }
    }

    private fun validadeFilds(priceAlcool: String, priceGas: String): Boolean {
        textInputAlcool.error = null
        textInputGas.error = null

        if (priceAlcool.isEmpty()) {
            textInputAlcool.error = "Digite o preço do álcool"
            return false
        } else if (priceGas.isEmpty()) {
            textInputGas.error = "Digite o preço da gasolina"
            return false
        }
        return true
    }

    private fun initViewsComponents() {
        textInputAlcool = findViewById(R.id.text_input_alcool)
        editAlcool = findViewById(R.id.edit_alcool)

        textInputGas = findViewById(R.id.text_input_gas)
        editGas = findViewById(R.id.edit_gas)

        btnCalc = findViewById(R.id.btn_calcular)
        textResult = findViewById(R.id.text_result)
    }
}