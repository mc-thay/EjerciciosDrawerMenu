package com.aguilar.ejerciciosdrawermenu

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configurar Drawer Layout
        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.navigation_view)

        // Configurar el toggle para el Drawer Menu
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Cargar el primer fragmento al iniciar
        if (savedInstanceState == null) {
            loadFragment(PrimalidadFragment())
        }

        // Configurar el listener para el Drawer Menu
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_primalidad -> loadFragment(PrimalidadFragment())
                R.id.menu_edades_relativas -> loadFragment(EdadesRelativasFragment())
                R.id.menu_area_triangulo -> loadFragment(AreaTrianguloFragment())
                R.id.menu_tiempo_construccion -> loadFragment(TiempoConstruccionFragment())
                R.id.menu_factores_compuestos -> loadFragment(FactoresCompuestosFragment())
                R.id.menu_comprobacion_compuestos -> loadFragment(ComprobacionCompuestosFragment())
            }
            drawerLayout.closeDrawers()
            true
        }
    }

    // Función para cargar el fragmento
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }
}
