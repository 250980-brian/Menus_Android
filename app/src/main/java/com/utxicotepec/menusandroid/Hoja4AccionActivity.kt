package com.utxicotepec.menusandroid

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja4AccionActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja4_accion)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)

        // ZONA A: aquí van las instrucciones del tutorial que van dentro de onCreate
        txtResultado.setOnLongClickListener {
            // Si el modo de acción ya está abierto, no hacemos nada
            if (actionMode != null) {
                return@setOnLongClickListener false
            }
            // Inicia el modo de acción usando el Callback de la ZONA B
            actionMode = startActionMode(actionModeCallback)
            true
        }
    }

    // ZONA B: aquí van las funciones del tutorial que van FUERA de onCreate
    // Variable global para controlar que no se abra la barra más de una vez al mismo tiempo
    private var actionMode: android.view.ActionMode? = null

    // ZONA B: aquí van las funciones del tutorial que van FUERA de onCreate
    private val actionModeCallback = object : android.view.ActionMode.Callback {

        override fun onCreateActionMode(mode: android.view.ActionMode, menu: android.view.Menu): Boolean {
            val inflater = mode.menuInflater
            inflater.inflate(R.menu.menu_hoja4, menu)
            mode.title = getString(R.string.titulo_modo)
            return true
        }

        override fun onPrepareActionMode(mode: android.view.ActionMode, menu: android.view.Menu): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: android.view.ActionMode, item: android.view.MenuItem): Boolean {
            return when (item.itemId) {
                R.id.item_modo_1 -> {
                    txtResultado.text = getString(R.string.sel_modo_1)
                    mode.finish() // Esta línea cierra la barra como pide la práctica
                    true
                }
                R.id.item_modo_2 -> {
                    txtResultado.text = getString(R.string.sel_modo_2)
                    mode.finish()
                    true
                }
                R.id.item_modo_3 -> {
                    txtResultado.text = getString(R.string.sel_modo_3)
                    mode.finish()
                    true
                }
                else -> false
            }
        }

        override fun onDestroyActionMode(mode: android.view.ActionMode) {
            actionMode = null
        }
    }
}
