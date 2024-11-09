package com.aguilar.ejerciciosdrawermenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class PrimalidadFragment : Fragment() {

    private lateinit var etNumeroPrimo: EditText
    private lateinit var btnVerificarPrimo: Button
    private lateinit var tvResultadoPrimalidad: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout del fragmento
        val rootView = inflater.inflate(R.layout.fragment_primalidad, container, false)

        // Inicializar las vistas
        etNumeroPrimo = rootView.findViewById(R.id.et_numero_primo)
        btnVerificarPrimo = rootView.findViewById(R.id.btn_verificar_primo)
        tvResultadoPrimalidad = rootView.findViewById(R.id.tv_resultado_primalidad)

        // Establecer el listener del botón
        btnVerificarPrimo.setOnClickListener {
            val numero = etNumeroPrimo.text.toString().toIntOrNull()
            if (numero != null && numero > 1) {
                verificarPrimalidad(numero)
            } else {
                tvResultadoPrimalidad.text = "Por favor ingresa un número mayor que 1."
            }
        }

        return rootView
    }

    // Función para verificar si un número es primo
    private fun verificarPrimalidad(numero: Int) {
        if (numero == 2) {
            tvResultadoPrimalidad.text = "$numero es un número primo."
            return
        }

        for (i in 2 until numero) {
            if (numero % i == 0) {
                tvResultadoPrimalidad.text = "$numero no es un número primo."
                return
            }
        }

        tvResultadoPrimalidad.text = "$numero es un número primo."
    }
}
