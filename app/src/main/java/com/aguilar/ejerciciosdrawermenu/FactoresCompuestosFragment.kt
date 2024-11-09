package com.aguilar.ejerciciosdrawermenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class FactoresCompuestosFragment : Fragment() {

    private lateinit var etNumero: EditText
    private lateinit var btnCalcularFactores: Button
    private lateinit var tvFactores: TextView
    private lateinit var tvComposicion: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_factores_compuestos, container, false)

        etNumero = rootView.findViewById(R.id.et_numero)
        btnCalcularFactores = rootView.findViewById(R.id.btn_calcular_factores)
        tvFactores = rootView.findViewById(R.id.tv_factores)
        tvComposicion = rootView.findViewById(R.id.tv_composicion)

        // Establecer el listener para el botón
        btnCalcularFactores.setOnClickListener {
            val numero = etNumero.text.toString().toIntOrNull()
            if (numero != null && numero > 0) {
                calcularFactores(numero)
            } else {
                tvFactores.text = "Por favor ingresa un número válido."
                tvComposicion.text = ""
            }
        }

        return rootView
    }

    // Función para calcular los factores de un número
    private fun calcularFactores(numero: Int) {
        val factores = mutableListOf<Int>()
        for (i in 1..numero) {
            if (numero % i == 0) {
                factores.add(i)
            }
        }

        // Mostrar los factores
        tvFactores.text = "Factores de $numero: ${factores.joinToString(", ")}"

        // Determinar si es compuesto
        if (factores.size > 2) {
            tvComposicion.text = "$numero es un número compuesto."
        } else {
            tvComposicion.text = "$numero no es un número compuesto."
        }
    }
}
