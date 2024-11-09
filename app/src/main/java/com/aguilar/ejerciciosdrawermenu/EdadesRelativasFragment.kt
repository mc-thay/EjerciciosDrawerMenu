package com.aguilar.ejerciciosdrawermenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class EdadesRelativasFragment : Fragment() {

    private lateinit var etEdadAna: EditText
    private lateinit var btnCalcularEdades: Button
    private lateinit var tvResultadoEdades: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_edades_relativas, container, false)

        etEdadAna = rootView.findViewById(R.id.et_edad_ana)
        btnCalcularEdades = rootView.findViewById(R.id.btn_calcular_edades)
        tvResultadoEdades = rootView.findViewById(R.id.tv_resultado_edades)

        // Establecer el listener para el botón
        btnCalcularEdades.setOnClickListener {
            val edadAna = etEdadAna.text.toString().toIntOrNull()
            if (edadAna != null) {
                calcularEdades(edadAna)
            } else {
                tvResultadoEdades.text = "Por favor ingresa una edad válida para Ana."
            }
        }

        return rootView
    }

    // Función para calcular la edad de Juan y mostrar el resultado
    private fun calcularEdades(edadAna: Int) {
        val edadJuan = edadAna - 5 // Sabemos que Ana tiene 5 años más que Juan
        val resultado = "Edad de Ana: $edadAna años\nEdad de Juan: $edadJuan años"
        tvResultadoEdades.text = resultado
    }
}
