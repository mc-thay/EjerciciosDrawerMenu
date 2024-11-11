package com.aguilar.ejerciciosdrawermenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.widget.Toast

class AreaTrianguloFragment : Fragment() {

    private lateinit var etBase: EditText
    private lateinit var etAltura: EditText
    private lateinit var btnCalcularArea: Button
    private lateinit var tvResultado: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflamos el layout del fragmento
        context?.theme?.applyStyle(R.style.Theme_EjerciciosDrawerMenu, true)
        val rootView = inflater.inflate(R.layout.fragment_area_triangulo, container, false)

        // Inicializamos las vistas
        etBase = rootView.findViewById(R.id.et_base)
        etAltura = rootView.findViewById(R.id.et_altura)
        btnCalcularArea = rootView.findViewById(R.id.btn_calcular_area)
        tvResultado = rootView.findViewById(R.id.tv_resultado)

        // Configuramos el botón para calcular el área
        btnCalcularArea.setOnClickListener {
            calcularArea()
        }

        return rootView
    }

    private fun calcularArea() {
        // Obtenemos los valores ingresados por el usuario
        val base = etBase.text.toString().toDoubleOrNull()
        val altura = etAltura.text.toString().toDoubleOrNull()

        if (base != null && altura != null) {
            // Fórmula del área de un triángulo: área = (base * altura) / 2
            val area = (base * altura) / 2
            // Mostramos el resultado
            tvResultado.text = "Área: $area"
        } else {
            // Si los valores no son válidos, mostramos un mensaje de error
            Toast.makeText(context, "Por favor ingrese valores válidos para la base y la altura", Toast.LENGTH_SHORT).show()
        }
    }
}
