package com.utxicotepec.menusandroid

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja2GruposActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja2_grupos)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)

        // ZONA A: aquí van las instrucciones del tutorial que van dentro de onCreate
    }

    // ZONA B: aquí van las funciones del tutorial que van FUERA de onCreate
    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_hoja2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        // Esta línea es obligatoria para que la palomita se mueva visualmente a la opción elegida
        item.isChecked = true

        return when (item.itemId) {
            R.id.item_grupo_1 -> {
                txtResultado.text = getString(R.string.sel_grupo_1)
                true
            }
            R.id.item_grupo_2 -> {
                txtResultado.text = getString(R.string.sel_grupo_2)
                true
            }
            R.id.item_grupo_3 -> {
                txtResultado.text = getString(R.string.sel_grupo_3)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
