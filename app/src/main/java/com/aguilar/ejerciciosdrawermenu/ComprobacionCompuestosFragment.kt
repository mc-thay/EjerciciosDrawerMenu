package com.aguilar.ejerciciosdrawermenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class ComprobacionCompuestosFragment : Fragment() {

    private lateinit var etNumber: EditText
    private lateinit var btnCheckComposed: Button
    private lateinit var tvResult: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_comprobacion_compuestos, container, false)

        etNumber = rootView.findViewById(R.id.et_number)
        btnCheckComposed = rootView.findViewById(R.id.btn_check_composed)
        tvResult = rootView.findViewById(R.id.tv_result)

        // Establecer el listener para el botón
        btnCheckComposed.setOnClickListener {
            val number = etNumber.text.toString().toIntOrNull()
            if (number != null) {
                checkIfComposed(number)
            } else {
                tvResult.text = "Por favor ingresa un número válido."
            }
        }

        return rootView
    }

    // Función para verificar si el número es compuesto y mostrar los factores
    private fun checkIfComposed(number: Int) {
        val factors = mutableListOf<Int>()
        for (i in 1..number) {
            if (number % i == 0) {
                factors.add(i)
            }
        }

        val isComposed = factors.size > 2 // Un número compuesto tiene más de 2 factores (1 y él mismo)
        val factorsText = "Factores de $number: ${factors.joinToString(", ")}"
        val resultText = if (isComposed) {
            "$factorsText\nEl número $number es compuesto."
        } else {
            "$factorsText\nEl número $number no es compuesto."
        }

        tvResult.text = resultText
    }
}
