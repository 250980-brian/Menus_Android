package com.utxicotepec.menusandroid

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja3ContextualActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja3_contextual)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)
        registerForContextMenu(txtResultado)

        // ZONA A: aquí van las instrucciones del tutorial que van dentro de onCreate
    }
    // 1. Aquí se infla el menú cuando el usuario deja presionado el TextView
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_hoja3, menu)
        menu.setHeaderTitle(getString(R.string.titulo_menu))
    }

    // 2. Aquí se manejan las acciones cuando el usuario selecciona una opción
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_edit -> {
                txtResultado.text = getString(R.string.sel_editar)
                true
            }
            R.id.action_share -> {
                txtResultado.text = getString(R.string.sel_compartir)
                true
            }
            R.id.action_delete -> {
                txtResultado.text = getString(R.string.sel_eliminar)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    // ZONA B: aquí van las funciones del tutorial que van FUERA de onCreate
}
