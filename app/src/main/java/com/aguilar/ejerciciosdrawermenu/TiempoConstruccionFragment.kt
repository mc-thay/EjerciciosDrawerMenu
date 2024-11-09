package com.aguilar.ejerciciosdrawermenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class TiempoConstruccionFragment : Fragment() {

    private lateinit var etNumeroTrabajadores: EditText
    private lateinit var etDiasIniciales: EditText
    private lateinit var btnCalcularTiempo: Button
    private lateinit var tvResultadoTiempo: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_tiempo_construccion, container, false)

        etNumeroTrabajadores = rootView.findViewById(R.id.et_numero_trabajadores)
        etDiasIniciales = rootView.findViewById(R.id.et_dias_iniciales)
        btnCalcularTiempo = rootView.findViewById(R.id.btn_calcular_tiempo)
        tvResultadoTiempo = rootView.findViewById(R.id.tv_resultado_tiempo)

        // Establecer el listener para el botón
        btnCalcularTiempo.setOnClickListener {
            val numeroTrabajadores = etNumeroTrabajadores.text.toString().toIntOrNull()
            val diasIniciales = etDiasIniciales.text.toString().toIntOrNull()

            if (numeroTrabajadores != null && diasIniciales != null) {
                calcularTiempo(numeroTrabajadores, diasIniciales)
            } else {
                tvResultadoTiempo.text = "Por favor ingresa valores válidos."
            }
        }

        return rootView
    }

    // Función para calcular el tiempo necesario
    private fun calcularTiempo(numeroTrabajadores: Int, diasIniciales: Int) {
        // Utilizando la fórmula proporcionada
        val trabajadoresIniciales = 4 // Número de trabajadores iniciales
        val tiempoNuevo = (trabajadoresIniciales * diasIniciales) / numeroTrabajadores
        tvResultadoTiempo.text = "El tiempo necesario será de: $tiempoNuevo días."
    }
}
